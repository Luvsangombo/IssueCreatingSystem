package projects.issuesystem.vote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping(path="/issues/{id}/votes")
    public String vote(@PathVariable int id) {
         voteService.save(id);
         return "Vote saved";
    }

}
