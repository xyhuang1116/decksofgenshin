package decks.decksofgenshin;

import java.util.HashMap;
import java.util.Map;

import decks.decksofgenshin.Card.Type;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardByIdConverter implements Converter<String, Card> {
    
    private Map<String, Card> cardMap = new HashMap<>();

    public CardByIdConverter() {
        cardMap.put("G", new Card("Ganyu","G",3,Type.CHARACTER,"Sources","desc1","desc2"));
        cardMap.put("C", new Card("Cyno","C",4,Type.CHARACTER,"Sources","desc1","desc2"));
        cardMap.put("EB", new Card("Echoing Ballad","EB",3,Type.WEAPON,"Sources","desc1","desc2"));
        cardMap.put("ES", new Card("Evil Shall","ES",3,Type.WEAPON,"Sources","desc1","desc2"));
        cardMap.put("SE", new Card("Stealthy Extraction","SE",3,Type.TALENT,"Sources","desc1","desc2"));
        cardMap.put("XC", new Card("Xiangling: Crossfire","XC",3,Type.TALENT,"Sources","desc1","desc2"));
    }

    @Override
    public Card convert(String id){
        return cardMap.get(id);
    }
}
