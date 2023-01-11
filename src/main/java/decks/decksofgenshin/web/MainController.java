package decks.decksofgenshin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import decks.decksofgenshin.data.CharaRepository;
import decks.decksofgenshin.data.CardRepository;
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
	private CharaRepository charaRepository;

    @Autowired
    private CardRepository cardRepository;
    
    @GetMapping
    public String addCharasToModel(Model model) {
        model.addAttribute("charas",charaRepository.findAll() );
        model.addAttribute("cards",cardRepository.findAll() );
        return "main";  //return the view name
    }

    @PostMapping
    public String addCardsToModel(Model model){
        model.addAttribute("charas",charaRepository.findAll() );
        model.addAttribute("cards",cardRepository.findAll() );
        return "cards"; 
    }

    
}
