package br.unesp.fc.blank.service;

import br.unesp.fc.blank.data.Unidade;
import java.util.List;

public interface UnidadeService {

    List<Unidade> listar();

    Unidade buscar(Integer id);

    Unidade salvar(Unidade unidade);

}
