package decks.decksofgenshin;

import lombok.Data;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class Deck {
    
    @NotNull
    @Size(min=1,max=50, message="Name must be in between 1-50 characters.")
    private String name;

    @NotNull
    private String id; // hashable id

    @NotNull(message="You must choose at least 1 card.")
    @Size(max=30,message="You can't choose more than 30 card.")
    private List<Card> cards; //TO_DO: Divide card list into character list and card list  

}
