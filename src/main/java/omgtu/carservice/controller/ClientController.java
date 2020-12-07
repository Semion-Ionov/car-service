package omgtu.carservice.controller;

import omgtu.carservice.dto.LoginModel;
import omgtu.carservice.model.Client;
import omgtu.carservice.service.ClientService;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody Client client) {
        return clientService.registrationUser(client);
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
