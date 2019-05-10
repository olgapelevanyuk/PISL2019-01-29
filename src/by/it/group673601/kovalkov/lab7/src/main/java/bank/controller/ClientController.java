package bank.controller;

import bank.entity.Client;
import bank.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bank")
public class ClientController {
    private final ClientRepo repo;

    @Autowired
    public ClientController(ClientRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/home")
    public String getMainPage() {
        return "home";
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addClient(@RequestBody Client client) {

        if (repo.existsById(client.getPassportId())) {
            return new ResponseEntity<>("Пользователь с данным номером паспорта уже существует", HttpStatus.BAD_REQUEST);
        }

        repo.save(client);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public @ResponseBody
    ResponseEntity updateClient(@RequestBody Client client) {

        if (!repo.existsById(client.getPassportId())) {
            return new ResponseEntity<>("Пользователь с данным номером паспорта не существует", HttpStatus.BAD_REQUEST);
        }
        System.out.println(client);
        repo.save(client);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{client_id}/delete")
    public @ResponseBody
    ResponseEntity deleteClient(@PathVariable(value = "client_id") String id) {
        if (!repo.existsById(id)) {
            return new ResponseEntity<>("Пользователь с данным номером паспорта не существует", HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/{client_id}/get")
    public @ResponseBody
    ResponseEntity getClientInfo(@PathVariable(value = "client_id") String id) {
        Optional<Client> byId = repo.findById(id);

        return byId
            .<ResponseEntity>map(client -> new ResponseEntity<>(client, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>("Пользователь с данным номером паспорта не существует", HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/status")
    public @ResponseBody
    ResponseEntity checkStatus() {
        System.out.println("healtcheck");
        return new ResponseEntity(HttpStatus.OK);
    }
}
