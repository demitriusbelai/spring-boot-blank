package br.unesp.fc.blank.controller;

import br.unesp.fc.blank.data.Unidade;
import br.unesp.fc.blank.data.UnidadeTelefone;
import br.unesp.fc.blank.dto.UnidadeDTO;
import br.unesp.fc.blank.dto.UnidadeTelefoneDTO;
import br.unesp.fc.blank.service.UnidadeService;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping(value="/unidades")
    public String unidades(Model model) {
        model.addAttribute("unidades", unidadeService.listar());
        return "unidade/unidades";
    }

    @GetMapping(value="/unidade/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Unidade unidade = unidadeService.buscar(id);

        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setNome(unidade.getNome());
        unidadeDTO.setTelefones(new ArrayList<>());

        for (UnidadeTelefone telefone : unidade.getTelefones()) {
            UnidadeTelefoneDTO telefoneDTO = new UnidadeTelefoneDTO();
            telefoneDTO.setId(telefone.getId());
            telefoneDTO.setDdd(telefone.getDdd());
            telefoneDTO.setNumero(telefone.getNumero());
            unidadeDTO.getTelefones().add(telefoneDTO);
        }

        model.addAttribute("unidade", unidadeDTO);
        return "unidade/cadastro";
    }

    @PostMapping(value="/unidade/telefone/adicionar")
    public String adicionarTelefone(@ModelAttribute UnidadeDTO unidadeDTO, Model model) {
        unidadeDTO.getTelefones().add(new UnidadeTelefoneDTO());
        model.addAttribute("unidade", unidadeDTO);
        return "unidade/cadastro";
    }

    @PostMapping(value="/unidade/telefone/remover/{index}")
    public String adicionarTelefone(@PathVariable Integer index,
            @ModelAttribute UnidadeDTO unidadeDTO, Model model) {
        unidadeDTO.getTelefones().remove(index.intValue());
        model.addAttribute("unidade", unidadeDTO);
        return "unidade/cadastro";
    }

    @PostMapping(value="/unidade/salvar")
    public String salvar(@ModelAttribute UnidadeDTO unidadeDTO) {
        Unidade unidade = unidadeService.buscar(unidadeDTO.getId());
        unidade.setNome(unidade.getNome());

        Set<Integer> telefoneIds = unidadeDTO.getTelefones().stream()
                .map(UnidadeTelefoneDTO::getId).collect(Collectors.toSet());

        unidade.getTelefones().removeIf(t -> !telefoneIds.contains(t.getId()));

        Map<Integer, UnidadeTelefone> mapTelefone = unidade.getTelefones().stream()
                .collect(Collectors.toMap(UnidadeTelefone::getId, Function.identity()));

        for (UnidadeTelefoneDTO telefoneDTO : unidadeDTO.getTelefones()) {
            UnidadeTelefone telefone;
            if (telefoneDTO.getId() != null) {
                telefone = mapTelefone.get(telefoneDTO.getId());
            } else {
                telefone = new UnidadeTelefone();
                unidade.getTelefones().add(telefone);
            }
            telefone.setDdd(telefoneDTO.getDdd());
            telefone.setNumero(telefoneDTO.getNumero());
        }

        unidadeService.salvar(unidade);

        return "redirect:/unidades";
    }

}
