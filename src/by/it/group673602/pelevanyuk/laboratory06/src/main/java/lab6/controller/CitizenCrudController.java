package lab6.controller;

import lab6.entity.Citizen;
import lab6.repo.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/user")
public class CitizenCrudController {
    private final CitizenRepo repo;

    @Autowired
    public CitizenCrudController(CitizenRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/get/{user_id}")
    public ResponseEntity findUserById(@PathVariable(name = "user_id") String userId) {
        return repo.findById(userId)
            .<ResponseEntity>map(citizen -> new ResponseEntity<>(citizen, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>("Citizen with provided id was not found",HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/add")
    public ResponseEntity addNewCitizen(@RequestBody @Valid Citizen citizen) {
        if (repo.existsById(citizen.getId())) {
            return new ResponseEntity<>("Already exists", HttpStatus.BAD_REQUEST);
        }
        repo.save(citizen);

        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @DeleteMapping(path = "/remove/{user_id}")
    public ResponseEntity removeCitizen(@PathVariable(name = "user_id") String userId) {
        if (!repo.existsById(userId)) {
            return new ResponseEntity<>("Citizen with provided passport id doesn't exist", HttpStatus.NOT_FOUND);
        }
        repo.deleteById(userId);

        return new ResponseEntity<>("Removed", HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity updateCitizen(@RequestBody @Valid Citizen citizen) {
        if (!repo.existsById(citizen.getId())) {
            return new ResponseEntity<>("Citizen with provided passport id doesn't exist", HttpStatus.BAD_REQUEST);
        }
        repo.save(citizen);

        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
}
