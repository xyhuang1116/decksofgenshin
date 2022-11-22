package decks.decksofgenshin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import decks.decksofgenshin.Card.Type;



@Slf4j
@Controller
@RequestMapping("/build")
@SessionAttributes("deckBuilding")
public class BuildDeckController {
    
    @ModelAttribute
    public void addCardsToModel(Model model){
        List<Card> cards = Arrays.asList(
            new Card("Ganyu","id",3,Type.CHARACTER,"Sources","desc1","desc2"),
            new Card("Cyno","id",4,Type.CHARACTER,"Sources","desc1","desc2"),
            new Card("Echoing Ballad: Skyward Harp","id",3,Type.WEAPON,"Sources","desc1","desc2"),
            new Card("Evil Shall Never Prevail: Lithic Spear","id",3,Type.WEAPON,"Sources","desc1","desc2"),
            new Card("Stealthy Extraction","id",3,Type.TALENT,"Sources","desc1","desc2"),
            new Card("Xiangling: Crossfire","id",3,Type.TALENT,"Sources","desc1","desc2")
        );

        Type[] types = Card.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(cards,type));
        }
    }

    @ModelAttribute(name = "deck")
    public Deck deck(){
        return new Deck();
    }

    @GetMapping
    public String showBuildForm(){
        return "build";
    }

    private Iterable<Card> filterByType( List<Card> cards, Type type){
        return cards
                .stream() // Functional programming! figure this out later
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}

