package br.com.unicuritiba.CadastroGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.CadastroGame.models.Game;

public interface GameRepository 
			extends JpaRepository<Game, Long>{

}
