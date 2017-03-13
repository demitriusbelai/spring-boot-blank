package br.unesp.fc.blank.service;

import br.unesp.fc.blank.data.Departamento;
import br.unesp.fc.blank.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscar(Integer id) {
        return departamentoRepository.findOne(id);
    }

    @Override
    @Transactional
    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        departamentoRepository.delete(id);
    }

}
