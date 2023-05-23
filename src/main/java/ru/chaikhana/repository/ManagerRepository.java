package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.Manager;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {
}