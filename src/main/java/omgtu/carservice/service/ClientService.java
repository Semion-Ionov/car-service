package omgtu.carservice.service;

import omgtu.carservice.dto.LoginModel;
import omgtu.carservice.model.Client;
import omgtu.carservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ActiveUsersService activeUsers;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        activeUsers = ActiveUsersService.getActiveUsersInstance();
    }


    public String registrationUser(Client client) {
        return activeUsers.putUser(clientRepository.save(client));
    }

    public String loginUser(LoginModel loginModel) {
        Client client = clientRepository.findByEmailAndPswd(loginModel.getEmail(),
                loginModel.getPswd());
        if (client == null) {
            return "{\"status\":\"401\",\"message\":\"Неверный логин или пароль\"}";
        }
        return "{\"status\":\"200\", \"token\":\"" + activeUsers.putUser(client) + "\", \"user\":{ \"name\":\"" + client.getName() + "\", \"surname\":\"" + client.getSurname() + "\", \"phone\":\"" + client.getPhone()+"\" ,\"email\":\"" + client.getEmail() + "\", \"pswd\":\"" + client.getPswd() + "\" }}";

    }

    public String getUserByToken(String token) {
        Client client = activeUsers.getUser(token);
        if (client == null) {
            return "{\"status\":\"401\",\"message\":\"Для данного токена не найдено соответствий с юзерами\"}";
        }
        return "{\"status\":\"200\",\"user\":{ \"name\":\"" + client.getName() + "\", \"surname\":\"" + client.getSurname() + "\", \"phone\":\"" + client.getPhone()+"\" ,\"email\":\"" + client.getEmail() + "\", \"pswd\":\"" + client.getPswd() + "\" }}";
    }

    public String logoutUser(String token) {
        activeUsers.removeUser(token);
        return "Successful";
    }
}
