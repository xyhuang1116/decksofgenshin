package decks.decksofgenshin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import decks.decksofgenshin.data.CharaRepository;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
	private CharaRepository charaRepository;
    
    @GetMapping
    public String addCharasToModel(Model model) {
        model.addAttribute("charas",charaRepository.findAll() );
        model.addAttribute("cards",charaRepository.findAll() );
        return "main";  //return the view name
    }

    
}
