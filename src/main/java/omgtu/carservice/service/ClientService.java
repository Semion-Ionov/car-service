package omgtu.carservice.service;

import omgtu.carservice.model.Client;
import omgtu.carservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private ActiveUsersService activeUsers;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        activeUsers = ActiveUsersService.getActiveUsersInstance();
    }


//    public String registrationUser(String userJson) {
//        Client client;
//        try {
//            client = gson.fromJson(userJson, Client.class);
//            Client client1 = clientRepository.save(client);
//        } catch (JsonSyntaxException ex) {
//            return gson.toJson(new Response(ResultType.ERROR, ex.getMessage()));
//        }
//        String token = activeUsers.putUser(client);
//        return gson.toJson(new Response(ResultType.SUCCESSFUL, token));
//    }
//
//    public String loginUser(String loginDataJson) {
//        LoginModel loginModel = gson.fromJson(loginDataJson, LoginModel.class);
//        Client client = clientRepository.findByEmailAndPswd(loginModel.getEmail(), loginModel.getPswd());
//        if (client == null) {
//            return gson.toJson(new Response(ResultType.ERROR, "wrong login or password"));
//        }
//        String token = activeUsers.putUser(client);
//        return gson.toJson(new Response(ResultType.SUCCESSFUL, token));
//    }
//
//    public String logoutUser(String tokenJson) {
//        RequestToken requestToken;
//        try {
//            requestToken = gson.fromJson(tokenJson, RequestToken.class);
//        } catch (JsonSyntaxException ex) {
//            return gson.toJson(new Response(ResultType.ERROR, ex.getMessage()));
//        }
//        activeUsers.removeUser(requestToken.getToken());
//        return gson.toJson(new Response(ResultType.SUCCESSFUL, ""));
//    }
}
