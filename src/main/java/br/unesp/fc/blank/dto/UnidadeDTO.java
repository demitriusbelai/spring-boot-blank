package br.unesp.fc.blank.dto;

import java.util.List;
import java.util.Objects;

public class UnidadeDTO {

    private Integer id;

    private String nome;

    private List<UnidadeTelefoneDTO> telefones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<UnidadeTelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<UnidadeTelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeDTO other = (UnidadeDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
