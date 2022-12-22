package decks.decksofgenshin.web;

import java.util.HashMap;
import java.util.Map;

import decks.decksofgenshin.Chara;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardByIdConverter implements Converter<String, Chara> {
    
    private Map<String, Chara> cardMap = new HashMap<>();

    public CardByIdConverter() {
    //     cardMap.put("G", new Chara("Ganyu","G",3,Type.CHARACTER,"Sources","desc1","desc2"));
    //     cardMap.put("C", new Chara("Cyno","C",4,Type.CHARACTER,"Sources","desc1","desc2"));
    }

    @Override
    public Chara convert(String id){
        return cardMap.get(id);
    }
}
