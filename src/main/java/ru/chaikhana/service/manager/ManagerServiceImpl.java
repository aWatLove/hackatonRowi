package ru.chaikhana.service.manager;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Manager;
import ru.chaikhana.repository.ManagerRepository;

@Service
@Data
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    @Override
    public Manager getManagerById(String id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public Manager addManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        managerRepository.delete(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }
}
