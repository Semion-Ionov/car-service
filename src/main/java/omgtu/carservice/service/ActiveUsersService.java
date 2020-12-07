package omgtu.carservice.service;


import omgtu.carservice.model.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActiveUsersService {
    private static ActiveUsersService activeUsersService;
    private Map<String, Client> authorizedUsers;//токен, клиент

    private ActiveUsersService() {
        authorizedUsers = new HashMap<>();
    }

    public static ActiveUsersService getActiveUsersInstance() {
        if (activeUsersService == null) {
            activeUsersService = new ActiveUsersService();
        }
        return activeUsersService;
    }

    public String putUser(Client client) {
        String token = UUID.randomUUID().toString();
        authorizedUsers.put(token, client);
        return token;
    }

    public Client getUser(String token) {
        return authorizedUsers.get(token);
    }

    public void removeUser(String token) {
        authorizedUsers.remove(token);
    }

    public boolean isActive(String token) {
        return authorizedUsers.get(token) != null;
    }
}
