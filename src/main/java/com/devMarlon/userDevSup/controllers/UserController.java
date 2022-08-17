package com.devMarlon.userDevSup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devMarlon.userDevSup.entities.User;
import com.devMarlon.userDevSup.repositories.UserRepository;

//Com essa conotação já está configurando essa classe 
//para ser um controlador e ela irá responder por requisições e com
//RequestMapping dirá qual caminho responder
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	//Para instanciar um novo objeto c/ mecanismo de 
	//injeção de dependência do Framework
	@Autowired
	private UserRepository repository;
	
	//esse repository findAll já manda uma consulta ao BD e busca todos os 
	//usuarios e retorna uma lista
	@GetMapping
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User insert(@RequestBody User user){
		User result = repository.save(user);
		return result;
	}
}

//Controlador Rest ou West é um controlador responsável por receber as 
//requisições do usuário e responder as requisições