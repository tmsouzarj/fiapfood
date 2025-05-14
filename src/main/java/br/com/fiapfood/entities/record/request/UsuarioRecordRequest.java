package br.com.fiapfood.entities.record.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRecordRequest(@Schema(description = "Nome do usuário", example = "Thiago") 
								   @NotBlank(message = "O campo nome precisa estar preenchido.")
								   @Size(min = 3, max = 150, message = "O campo nome precisa ter entre 3 e 150 caracteres.") 
								   String nome, 

								   @Schema(description = "Email do usuário", example = "thiago@fiapfood.com") 
								   @NotBlank(message = "O campo email precisa estar preenchido.")
							       @Size(min = 3, max = 70, message = "O campo email precisa ter entre 3 e 70 caracteres.") 
								   String email, 
	
							       //@NotNull(message = "Os dados do endereço precisam estar preenchidos.")
								   //@Schema(description = "Dados do endereço do usuário") DadosEnderecoRecord dadosEndereco,
								   
								   @NotNull(message = "É necessário informar o perfil de acesso para o usuário.")
								   @Schema(description = "IDs dos perfil de acesso do usuário.", example = "1") 
								   Integer perfil
								   
								   //@NotNull(message = "Dados de acesso do usuário.")
								   //@Schema(description = "Dados do login do usuário.", example = "1") LoginRecordRequest dadosLogin
								   ) { }