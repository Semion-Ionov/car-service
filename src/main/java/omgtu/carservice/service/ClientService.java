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
        return activeUsers.putUser(client);
    }

    public String logoutUser(String token) {
        activeUsers.removeUser(token);
        return "Successful";
    }
}
