package br.com.fiapfood.controllers.docs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiapfood.controllers.response.ErroResponse;
import br.com.fiapfood.controllers.response.SucessoResponse;
import br.com.fiapfood.entities.record.request.SenhaRecord;
import br.com.fiapfood.entities.record.request.UsuarioRecordRequest;
import br.com.fiapfood.entities.record.response.UsuarioRecordPaginacaoResponse;
import br.com.fiapfood.entities.record.response.UsuarioRecordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Tag(name = "Usuario", description = "Classe responsável por realizar as operações do usuário.")
public interface UsuarioDoc {

	@Operation(summary = "Realiza o cadastro do usuário no sistema.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201"), 
		@ApiResponse(responseCode = "400", 
					 description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar o cadastro do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<Void> cadastrar(@Valid @RequestBody UsuarioRecordRequest usuario);
	
	@Operation(summary = "Realiza a atualização do usuário no sistema.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204"), 
		@ApiResponse(responseCode = "400", 
					 description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar a atualização do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<Void> atualizar(@Valid @PathVariable @NotNull Integer id, @RequestBody UsuarioRecordRequest usuario);
	
	@Operation(summary = "Realiza a inativação do usuário.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
					 content = { @Content(mediaType = "application/json", 
										  schema = @Schema(implementation = ErroResponse.class), 
										  examples = @ExampleObject(value = "{\r\n"
							  				  	   + "    \"mensagem\": \"Usuário inativado com sucesso.\"\r\n"
							  				  	   + "}"))}),
		@ApiResponse(responseCode = "400", 
					 description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar ao realizar a inativação do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<SucessoResponse> inativar(@Schema(description = "ID do usuário", example = "1") @Valid @PathVariable @NotNull Integer id);
	
	@Operation(summary = "Realiza a reativação do usuário.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
					 content = { @Content(mediaType = "application/json", 
										  schema = @Schema(implementation = ErroResponse.class), 
										  examples = @ExampleObject(value = "{\r\n"
							  				  	   + "    \"mensagem\": \"Usuário reativado com sucesso.\"\r\n"
							  				  	   + "}"))}),
		@ApiResponse(responseCode = "400", 
					 description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar a reativação do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<SucessoResponse> reativar(@Schema(description = "ID do usuário", example = "1") @Valid @PathVariable @NotNull Integer id);
	
	@Operation(summary = "Realiza a busca do usuário utilizando o campo id como filtro.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
					 description = "Dados do usuário.", 
					 content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioRecordResponse.class)) }),
		@ApiResponse(responseCode = "400", 
					 description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar a busca do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<UsuarioRecordResponse> buscarUsuarioPorId(@Schema(description = "ID do usuário", example = "1") @PathVariable @NotNull @Valid Integer id);

	@Operation(summary = "Realiza a busca dos usuários.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
					 description = "Lista com os dados dos usuários.", 
					 content = { @Content(mediaType = "application/json", 
					 					  array = @ArraySchema(schema = @Schema(implementation = UsuarioRecordPaginacaoResponse.class)),
					 					  examples = @ExampleObject(value = "{\r\n"
											 					  		+ "    \"usuarios\": [\r\n"
											 					  		+ "        {\r\n"
											 					  		+ "            \"id\": 1,\r\n"
											 					  		+ "            \"nome\": \"Thiago Motta\",\r\n"
											 					  		+ "            \"email\": \"thiago@restaurantetudibaum.com\",\r\n"
											 					  		+ "            \"login\": \"us000001\",\r\n"
											 					  		+ "            \"ativo\": true,\r\n"
											 					  		+ "            \"dadosEndereco\": {\r\n"
											 					  		+ "                \"cidade\": \"São Gonçalo\",\r\n"
											 					  		+ "                \"cep\": \"24455450\",\r\n"
											 					  		+ "                \"bairro\": \"Nova Cidade\",\r\n"
											 					  		+ "                \"endereco\": \"Rua Aquidabã\",\r\n"
											 					  		+ "                \"estado\": \"Rio de Janeiro\",\r\n"
											 					  		+ "                \"numero\": 79,\r\n"
											 					  		+ "                \"complemento\": \"Casa 8\",\r\n"
											 					  		+ "                \"semNumero\": true\r\n"
											 					  		+ "            }\r\n"
											 					  		+ "        }\r\n"
											 					  		+ "    ],\r\n"
											 					  		+ "    \"dadosPaginacao\": {\r\n"
											 					  		+ "        \"paginaAtual\": 1,\r\n"
											 					  		+ "        \"totalPaginas\": 3,\r\n"
											 					  		+ "        \"totalItens\": 12\r\n"
											 					  		+ "    }\r\n"
											 					  		+ "}"))}),
		@ApiResponse(responseCode = "400", 
				     description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar a busca dos usuários.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<UsuarioRecordPaginacaoResponse> buscarUsuarios(@RequestParam(defaultValue = "1") Integer pagina);

	@Operation(summary = "Realiza a alteração da senha do usuário.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204"),
		@ApiResponse(responseCode = "400", 
				     description = "Bad Request.", 
					 content = { @Content(mediaType = "application/json", 
					    				  schema = @Schema(implementation = ErroResponse.class), 
					    				  examples = @ExampleObject(value = "{\r\n"
						    				  	  + "    \"mensagem\": \"Ocorreu um erro ao realizar a troca da senha do usuário.\"\r\n"
						    				  	  + "}"))})
	})
	ResponseEntity<SucessoResponse> trocarSenha(@PathVariable @Valid @NotNull Integer id, @RequestBody @NotNull SenhaRecord dadosSenha);
}