package ru.chaikhana.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.Client;
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
