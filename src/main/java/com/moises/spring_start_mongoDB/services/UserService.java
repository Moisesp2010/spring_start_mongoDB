package com.moises.spring_start_mongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.spring_start_mongoDB.domain.AuthorDTO;
import com.moises.spring_start_mongoDB.dto.UserDTO;
import com.moises.spring_start_mongoDB.repository.UserRepository;
import com.moises.spring_start_mongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<AuthorDTO> findAll() {
		return repo.findAll();
	}

	public AuthorDTO findById(String id) {
		Optional<AuthorDTO> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public AuthorDTO insert(AuthorDTO obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public AuthorDTO update(AuthorDTO obj) {
		AuthorDTO newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(AuthorDTO newObj, AuthorDTO obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public AuthorDTO fromDTO(UserDTO objDto) {
		return new AuthorDTO(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}