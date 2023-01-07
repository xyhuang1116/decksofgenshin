package decks.decksofgenshin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import decks.decksofgenshin.data.CharaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class CharasController {

    @Autowired
	private CharaRepository charaRepository;
    
    @GetMapping
    public String addCharasToModel(Model model) {
        model.addAttribute("charas",charaRepository.findAll() );
        return "charas";  //return the view name
    }

    
}
