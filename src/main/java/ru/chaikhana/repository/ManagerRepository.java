package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {
    List<Manager> findAllManagerByCategory(String category);
}
