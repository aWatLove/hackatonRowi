package ru.chaikhana.service.manager;

import ru.chaikhana.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManager();
    List<Manager> getAllManagerByCategory(String category);
    Manager getManagerById(String id);
    Manager addManager(Manager manager);
    void deleteManager(Manager manager);
    Manager updateManager(Manager manager);
}
