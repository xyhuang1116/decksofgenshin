package decks.decksofgenshin;

import lombok.Data;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Deck {
    
    @NotNull
    @Size(max=50, message="Name must be at most 50 characters long.")
    private String name;

    @NotNull
    private String id; // hashable id

    @NotNull
    @Size(min=1, message="You must choose at least 1 card.")
    private List<Card> cards; //TO_DO: Divide card list into character list and card list  

}
