package com.charactersapi;

import com.charactersapi.entity.Character;
import com.charactersapi.service.CharacterService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class CharactersApiApplication {

	private static final String json = "characters.json";

	@Autowired
	private CharacterService characterService;

	public static void main(String[] args)  {
		SpringApplication.run(CharactersApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> loadData();
	}

	private String getURL() throws IOException {
		Path currentRelativePath = Paths.get("");
		String PATH = currentRelativePath.toAbsolutePath().toString().replace("\\", "\\\\")+"\\\\";
		return new String(Files.readAllBytes(Paths.get(PATH+json)), StandardCharsets.UTF_8);
	}

	private  void loadData() {
		try {
			String url = getURL();
			Gson gson= new Gson();
			if(characterService.findAll().size()==0) {
				JsonArray arry = new JsonParser().parse(url).getAsJsonArray();
				for (JsonElement jsonElement : arry) {
					characterService.insert(gson.fromJson(jsonElement, Character.class));
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}


}
