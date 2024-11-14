package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.ResourceNotFoundException;
import com.example.springboot.dtos.ModelDTO;
import com.example.springboot.models.Model;
import com.example.springboot.repositorio.repositorio;


@Service
public class ModelService {

    @Autowired
    private repositorio repositorio;

    @Autowired
    private ModelMapper modelMapper;



    // Salvar Model e retornar o ModelDTO
    public ModelDTO salvar(ModelDTO modelDTO) {
        Model model = modelMapper.map(modelDTO, Model.class);  // Converte o DTO para a entidade Model
        return modelMapper.map(repositorio.save(model), ModelDTO.class);  // Salva e converte a entidade salva de volta para DTO
    }
    

    //listar clientes e retornar DTO
    public List<ModelDTO> listar() {
        List<Model> models = repositorio.findAll();  // Obtém a lista de Clientes do banco de dados
        return modelMapper.map(models, new TypeToken<List<ModelDTO>>(){}.getType());  // Converte a lista de Model para ModelDTO
    }
    



    // Buscar um Cliente por ID e retornar o ModelDTO
    public Optional<ModelDTO> buscarPorId(Long id) {
        Optional<Model> modelOpt = repositorio.findById(id);        // Busca a entidade no banco de dados
        return modelOpt.map(model -> modelMapper.map(model, ModelDTO.class));       // Converte a entidade para ModelDTO, caso encontrado
    }



    // Deletar Cliente por ID
    public void deletar(Long id) {
        repositorio.deleteById(id);
    }


// Pesquisar Cliente por nome e retornar uma lista DTO
    public List<ModelDTO> pesquisarPorNome(String nome) {
        List<Model> models = repositorio.findByNomeContaining(nome);  // Pesquisa a lista de Clientes no banco de dados
        return modelMapper.map(models, new TypeToken<List<ModelDTO>>(){}.getType());  // Converte a lista de Model para ModelDTO
    }
    



    //atualizar a lista de clientes/ou mudar cliente
public ModelDTO atualizar(Long id, ModelDTO modelDTO) {
    // Tenta buscar a entidade pelo ID
    Model model = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o ID: " + id));
    modelMapper.map(modelDTO, model);       // Mapeia os dados do DTO para a entidade
    Model modelAtualizado = repositorio.save(model);        // Salva a entidade atualizada
    return modelMapper.map(modelAtualizado, ModelDTO.class);         // Retorna o DTO atualizado
}


}




















