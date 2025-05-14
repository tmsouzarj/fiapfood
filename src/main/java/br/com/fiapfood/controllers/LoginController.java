package br.com.fiapfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiapfood.controllers.docs.LoginDoc;
import br.com.fiapfood.controllers.response.SucessoResponse;
import br.com.fiapfood.entities.record.request.LoginRecordRequest;
import br.com.fiapfood.entities.record.request.SenhaRecordRequest;
import br.com.fiapfood.services.LoginService;
import br.com.fiapfood.utils.MensagensUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController implements LoginDoc {
	
	@Autowired
	protected LoginService loginService;
	
	@Override
	@PostMapping
	public ResponseEntity<SucessoResponse> validar(LoginRecordRequest dados) {		
		log.info("realizaLogin():dados do login {}", dados);

		return ResponseEntity.ok().body(new SucessoResponse(loginService.validar(dados)));		
	}
	
	@Override
	@PatchMapping("/{id}/senha/altera")
	public ResponseEntity<SucessoResponse> trocarSenha(Integer id, SenhaRecordRequest dados) {
		log.info("trocar senha():id {} - senha {}", id, dados.senha());

		loginService.trocarSenha(id, dados.senha());
		
		return ResponseEntity.ok(new SucessoResponse(MensagensUtil.recuperarMensagem(MensagensUtil.SUCESSO_TROCA_SENHA_USUARIO)));
	}
}