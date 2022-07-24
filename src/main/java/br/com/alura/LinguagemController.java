package br.com.alura;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class
LinguagemController {


	@Autowired
	private LinguagemRepository repositorio;

	@GetMapping(value="/linguagens")
	@ResponseStatus(HttpStatus.OK)
	public List<Linguagem> obterLinguagens(){
		
		List<Linguagem> linguagens = repositorio.findAll();
		return linguagens;
	}
	
	@PostMapping(value="/linguagens")
	@ResponseStatus(HttpStatus.CREATED)
	public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
	
		Linguagem linguagemSalva = repositorio.save(linguagem);
		
		
		return linguagemSalva;
	}
	
	@DeleteMapping("linguagens/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletarLinguagem(@PathVariable String id) {
		repositorio.deleteById(id);
		
		return ;
	}
	
	@GetMapping(value="/linguagens/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Linguagem obterTodasLinguagens(@PathVariable String id) {
		
		Linguagem linguagens = repositorio.findById(id).orElse(null);
		return linguagens;
	}
	
	@PutMapping(value="/linguagens/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Linguagem alterarLinguagens(@PathVariable String id, @RequestBody Linguagem linguagem){
		
		Linguagem linguagens = repositorio.findById(id).orElse(null);
		BeanUtils.copyProperties(linguagem, linguagens, "id");
		return repositorio.save(linguagens);
	}
}
