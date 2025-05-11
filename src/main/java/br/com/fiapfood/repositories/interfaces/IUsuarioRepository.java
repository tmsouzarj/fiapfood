package br.com.fiapfood.repositories.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiapfood.entities.db.UsuarioEntity;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	@Query("select u "
		 + "from UsuarioEntity u "
		 + "where u.login = ?1"
		 + "  and u.senha = ?2"
		 + "  and u.isAtivo = true")
	Optional<UsuarioEntity> findUsuarioAtivoPorLoginSenha(@Param("1") String login, @Param("2") String senha);

	Optional<UsuarioEntity> findByLoginAndIsAtivoTrue(String login);
	
	Optional<UsuarioEntity> findByIdAndIsAtivoTrue(Integer id);

	Optional<UsuarioEntity> findByIdAndIsAtivoFalse(Integer id);
}