package decks.decksofgenshin.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import decks.decksofgenshin.Chara;
import decks.decksofgenshin.Deck;
import decks.decksofgenshin.Chara.Element;



@Slf4j
@Controller
@RequestMapping("/build")
@SessionAttributes("card")
public class BuildDeckController {
    
    @GetMapping
    public String addCardsToModel(Model model){
        // List<Chara> cards = Arrays.asList(
        //     new Chara("Ganyu","G",3,Type.CHARACTER,"Sources","desc1","desc2"),
        //     new Chara("Cyno","C",4,Type.CHARACTER,"Sources","desc1","desc2"),
        //     new Chara("Echoing Ballad: Skyward Harp","EB",3,Type.WEAPON,"Sources","desc1","desc2"),
        //     new Chara("Evil Shall Never Prevail: Lithic Spear","ES",3,Type.WEAPON,"Sources","desc1","desc2"),
        //     new Chara("Stealthy Extraction","SE",3,Type.TALENT,"Sources","desc1","desc2"),
        //     new Chara("Xiangling: Crossfire","XC",3,Type.TALENT,"Sources","desc1","desc2")
        // );

        // Type[] types = Chara.Type.values();
        // for (Type type : types){
        //     model.addAttribute(type.toString().toLowerCase(),filterByType(cards,type));
        // }

        model.addAttribute("build", new Deck());
        return "build";
    }

    @ModelAttribute(name = "deck")
    public Deck deck(){
        return new Deck();
    }

 

    @PostMapping
    public String processDeck(@Valid Deck deck, Errors errors,SessionStatus sessionStatus){   
        
        if(errors.hasErrors()){
            return "build";  //TO-DO: the page doesn't show card list
        }
       
        log.info("Saving deck:{}", deck);
        sessionStatus.setComplete();
        return "redirect:/decks/current";
    }

    // private List<Chara> filterByType (List<Chara> cards, Type type){
    //     return cards
    //             .stream() // Functional programming! figure this out later
    //             .filter(x -> x.getType().equals(type))
    //             .collect(Collectors.toList());
    // }

}

