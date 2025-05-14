package br.com.fiapfood.entities.record.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record LoginRecordRequest(@Schema(description = "Matrícula do usuário", example = "us000001") String matricula, 
								 @Schema(description = "Senha do usuário", example = "123456") String senha) { 
	public LoginRecordRequest(@NotBlank(message = "O campo login não foi informado.") 
							  String matricula, 
							  @NotBlank(message = "O campo senha não foi informado.") String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}
}