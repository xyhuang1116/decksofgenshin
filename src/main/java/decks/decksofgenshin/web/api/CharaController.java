package decks.decksofgenshin.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import decks.decksofgenshin.Chara;
import decks.decksofgenshin.data.CharaRepository;

@RestController
@RequestMapping(path="/api/chara",
 produces="application/json")
@CrossOrigin(origins="http://decksofgenshin:8080")
public class CharaController {
    private CharaRepository charaRepo;

    public CharaController(CharaRepository charaRepo) {
        this.charaRepo = charaRepo;
    }

    @GetMapping(params="recent")
    public Iterable<Chara> recentChara() {
        PageRequest page = PageRequest.of(0, 12);
        return charaRepo.findAll(page).getContent();
    }
}
