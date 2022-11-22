package decks.decksofgenshin;

import lombok.Data;
import java.util.List;

@Data
public class Deck {
    
    private String name;
    private String id; // hashable id
    private List<Card> cards; //TO_DO: Divide card list into character list and card list  

}
