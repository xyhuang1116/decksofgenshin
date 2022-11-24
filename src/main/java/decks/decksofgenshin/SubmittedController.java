package decks.decksofgenshin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/decks")
public class SubmittedController {
    
    @GetMapping("/current")
    public String decks() {
        return "decks";  //return the view name
    }
}
