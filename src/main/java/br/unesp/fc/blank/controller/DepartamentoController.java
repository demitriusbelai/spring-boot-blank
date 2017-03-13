package br.unesp.fc.blank.controller;

import br.unesp.fc.blank.data.Departamento;
import br.unesp.fc.blank.dto.DepartamentoDTO;
import br.unesp.fc.blank.service.DepartamentoService;
import br.unesp.fc.blank.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping(value="/departamentos")
    public String departamentos(Model model) {
        model.addAttribute("departamentos", departamentoService.listar());
        return "departamento/departamentos";
    }

    @GetMapping(value="/departamento/incluir")
    public String incluir(Model model) {
        model.addAttribute("departamento", new DepartamentoDTO());
        model.addAttribute("unidades", unidadeService.listar());
        return "departamento/cadastro";
    }

    @GetMapping(value="/departamento/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Departamento departamento = departamentoService.buscar(id);

        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setId(departamento.getId());
        departamentoDTO.setNome(departamento.getNome());
        departamentoDTO.setUnidade(departamento.getUnidade().getId());

        model.addAttribute("departamento", departamentoDTO);
        model.addAttribute("unidades", unidadeService.listar());
        return "departamento/cadastro";
    }

    @PostMapping(value="/departamento/salvar")
    public String salvar(@ModelAttribute DepartamentoDTO departamentoDTO) {
        Departamento departamento;

        if (departamentoDTO.getId() != null) {
            departamento = departamentoService.buscar(departamentoDTO.getId());
        } else {
            departamento = new Departamento();
        }

        departamento.setNome(departamentoDTO.getNome());
        departamento.setUnidade(
                unidadeService.buscar(departamentoDTO.getUnidade()));

        departamentoService.salvar(departamento);

        return "redirect:/departamentos";
    }

    @PostMapping(value="/departamento/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        departamentoService.excluir(id);

        return "redirect:/departamentos";
    }

}
