package br.unesp.fc.blank.service;

import br.unesp.fc.blank.data.Unidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.unesp.fc.blank.repository.UnidadeRepository;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Unidade> listar() {
        return unidadeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Unidade buscar(Integer id) {
        return unidadeRepository.findOne(id);
    }

    @Override
    @Transactional
    public Unidade salvar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

}
