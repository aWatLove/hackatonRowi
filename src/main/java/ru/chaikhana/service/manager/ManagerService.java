package ru.chaikhana.service.manager;

import ru.chaikhana.model.Manager;

public interface ManagerService {
    Manager getManagerById(String id);
    Manager addManager(Manager manager);
    void deleteManager(Manager manager);
    Manager updateManager(Manager manager);
}
