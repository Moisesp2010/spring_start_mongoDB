package com.moises.spring_start_mongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moises.spring_start_mongoDB.domain.AuthorDTO;
import com.moises.spring_start_mongoDB.domain.Post;
import com.moises.spring_start_mongoDB.repository.PostRepository;
import com.moises.spring_start_mongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postReposiroty;

	@Autowired
	private UserRepository userReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		AuthorDTO maria = new AuthorDTO(null, "Maria Brown", "maria@gmail.com");
		AuthorDTO alex = new AuthorDTO(null, "Alex Green", "alex@gmail.com");
		AuthorDTO bob = new AuthorDTO(null, "Bob Grey", "bob@gmail.com");

		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO());
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO());
		
		postReposiroty.saveAll(Arrays.asList(post1, post2));
	}

}