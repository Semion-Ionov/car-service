package omgtu.carservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import omgtu.carservice.dto.LoginModel;
import omgtu.carservice.dto.LoginResponseModel;
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
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(new LoginResponseModel(200, activeUsers.putUser(client), client));
    }

    public String getUserByToken(String token) {
        Client client = activeUsers.getUser(token);
        if (client == null) {
            return "{\"status\":\"401\",\"message\":\"Для данного токена не найдено соответствий с юзерами\"}";
        }
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(new LoginResponseModel(200, activeUsers.putUser(client), client));
    }

    public String logoutUser(String token) {
        activeUsers.removeUser(token);
        return "{\"message\":\"Successful\"}";
    }
}
