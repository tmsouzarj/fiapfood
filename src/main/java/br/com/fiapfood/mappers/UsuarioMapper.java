package br.com.fiapfood.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.fiapfood.entities.db.UsuarioEntity;
import br.com.fiapfood.entities.domain.UsuarioDomain;
import br.com.fiapfood.entities.record.request.UsuarioRecordRequest;
import br.com.fiapfood.entities.record.response.PaginacaoRecordResponse;
import br.com.fiapfood.entities.record.response.UsuarioRecordPaginacaoResponse;
import br.com.fiapfood.entities.record.response.UsuarioRecordResponse;

@Component
public abstract class UsuarioMapper {

	// record -> domain -> entity
	
	// 1 - record -> domain
	public static UsuarioDomain toUsuario(UsuarioRecordRequest usuario) {
		return new UsuarioDomain(null,
							     usuario.nome(), 
							     usuario.email(), 
							     LocalDateTime.now(),
							     null,
							     true,
							     null, // DadosEnderecoMapper.toDadosEndereco(usuario.dadosEndereco()),
							     PerfilAcessoMapper.toPerfil(usuario.perfil()),
							     null //LoginMapper.toLogin(usuario.dadosLogin())
							     );
	}

	// 2 - domain -> entity
	
	public static UsuarioEntity toUsuario(UsuarioDomain usuario) {	
		return new UsuarioEntity(usuario.getId(),
								 usuario.getNome(), 
								 usuario.getEmail(), 
								 usuario.getDataCriacao(),
								 usuario.getDataAtualizacao(),
								 usuario.getIsAtivo(),
								 null,
								 PerfilAcessoMapper.toPerfil(usuario.getPerfil()),
								 null);
	}
	
	// entity -> domain -> record
	
	// 3 - entity -> domain
	
	public static UsuarioDomain toUsuario(UsuarioEntity usuario) {
		return new UsuarioDomain(usuario.getId(),
								 usuario.getNome(), 
							     usuario.getEmail(), 
								 usuario.getDataCriacao(),
								 usuario.getDataAtualizacao(),
								 usuario.getIsAtivo(),
							     DadosEnderecoMapper.toDadosEndereco(usuario.getDadosEndereco()),
							     PerfilAcessoMapper.toPerfil(usuario.getPerfil()),
							     LoginMapper.toLogin(usuario.getDadosLogin()));
	}
	
	// 4 - domain -> record
	
	public static UsuarioRecordResponse toUsuarioRecord(UsuarioDomain usuario) {
		return new UsuarioRecordResponse(usuario.getId(), 
										 usuario.getNome(), 
										 usuario.getEmail(), 
										 usuario.getDadosLogin().getMatricula(),
										 usuario.getIsAtivo(),
										 DadosEnderecoMapper.toDadosEnderecoRecord(usuario.getDadosEndereco()),
										 PerfilAcessoMapper.toPerfilRecord(usuario.getPerfil()));
	}

	public static UsuarioRecordPaginacaoResponse toUsuario(Page<UsuarioEntity> dados) {
		List<UsuarioRecordResponse> usuarios = dados.toList()
													.stream()
													.map(u -> UsuarioMapper.toUsuario(u))
													.map(u -> UsuarioMapper.toUsuarioRecord(u))
													.collect(Collectors.toList());
		
		PaginacaoRecordResponse dadosPaginacao = new PaginacaoRecordResponse(dados.getNumber() + 1, dados.getTotalPages(), Long.valueOf(dados.getTotalElements()).intValue());
		
		return new UsuarioRecordPaginacaoResponse(usuarios, dadosPaginacao);
	}
}