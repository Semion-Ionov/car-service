package omgtu.carservice.controller;

import omgtu.carservice.dto.LoginModel;
import omgtu.carservice.model.Client;
import omgtu.carservice.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseBody
    @PostMapping("/registration")
    public String registration(@RequestBody Client client) {
        return "{\"token\":\"" + clientService.registrationUser(client) + "\", \"user\":\"{ \"name\":\"" + client.getName() + "\", \"surname\":\"" + client.getSurname() + "\", \"phone\":\"" + client.getEmail() + "\", \"pswd\":\"" + client.getPswd() + "\" }\"}";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginModel loginModel) {
        return clientService.loginUser(loginModel);
    }

    @PostMapping("/logout")
    public String logout(@CookieValue(value = "token") String token) {
        return clientService.logoutUser(token);
    }
}
