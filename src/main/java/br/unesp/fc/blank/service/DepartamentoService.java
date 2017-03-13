package br.unesp.fc.blank.service;

import br.unesp.fc.blank.data.Departamento;
import java.util.List;

public interface DepartamentoService {

    List<Departamento> listar();

    Departamento buscar(Integer id);

    Departamento salvar(Departamento departamento);

    void excluir(Integer id);

}
