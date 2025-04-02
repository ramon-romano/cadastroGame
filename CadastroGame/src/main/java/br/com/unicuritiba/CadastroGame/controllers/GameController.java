package br.com.unicuritiba.CadastroGame.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.CadastroGame.models.Game;
import br.com.unicuritiba.CadastroGame.repositories.GameRepository;

@RestController
//@RestMapping("/games")
public class GameController {
	
	@Autowired
	GameRepository repository;
	
	@GetMapping("/games")
	public ResponseEntity<List<Game>> getGames(){
		return ResponseEntity.ok(repository.findAll());	
	}

	@PostMapping("/games")
	public ResponseEntity<Game> saveGame(
			@RequestBody Game game){
		Game gameSalvo = repository.save(game);
		return ResponseEntity.ok(gameSalvo);
	}
		
	@DeleteMapping("/games/{id}")
	public void removeGame(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
	@PutMapping("/games/{id}")
	public ResponseEntity<Game> update(@PathVariable long id, @RequestBody Game game){
		Optional<Game> existingGame = repository.findById(id);
		if (existingGame.isPresent()) {
			Game updatedGame = repository.save(game);
			return ResponseEntity.ok(updatedGame);
        }
        return ResponseEntity.notFound().build();
    }
	
}
