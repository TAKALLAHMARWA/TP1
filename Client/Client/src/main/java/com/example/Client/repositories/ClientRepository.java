package com.example.Client.repositories;

import com.example.Client.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>
{

    static CommandLineRunner initialiserBaseH2(ClientRepository clientRepository)
    {
        return args ->
        {
            clientRepository.save(new Client(Long.parseLong("1"),"Salma","harcha",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("2"),"Amina","Amin",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"),"salma","Linou",Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("4"),"amal","amali",Float.parseFloat("23")));

        };
    }


}
