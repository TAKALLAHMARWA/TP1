package com.example.Service.voiture;

import com.example.Service.voiture.entities.Client;
import com.example.Service.voiture.entities.Voiture;
import com.example.Service.voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VoitureApplication {

	@Autowired
	private VoitureRepository voitureRepository;

	@Autowired
	private ClientService clientService; // Feign client pour appeler le service client

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

	@Bean
	CommandLineRunner initialiserBaseH2() {
		return args -> {
			// Appel des méthodes du client Feign pour récupérer des clients
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);

			System.out.println("**************************");
			System.out.println("Client 1 - Id: " + c2.getId() + ", Nom: " + c2.getNom());
			System.out.println("Client 2 - Id: " + c1.getId() + ", Nom: " + c1.getNom());
			System.out.println("**************************");

			// Insertion des voitures avec les clients récupérés via Feign
			voitureRepository.save(new Voiture(1L, "Toyota", "A 25 333", "Corolla", 1L, c2));
			voitureRepository.save(new Voiture(2L, "Renault", "B 6 3456", "Megane", 1L, c2));
			voitureRepository.save(new Voiture(3L, "Peugeot", "A 55 4444", "301", 2L, c1));
		};
	}
}
