package decks.decksofgenshin;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
public class Deck {
    
    @NotNull
    @Size(min=1, max=50, message="Name must be in between 1-50 characters.")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // hashable id

    @NotNull(message="You must choose at least 1 card.")
    @Size(min=33, max=33, message="You can't choose more than 33 card.")
    @ManyToMany()
    private List<Card> cards = new ArrayList<>(); //TO_DO: Divide card list into character list and card list  

    public void addCard(Card card) {
        this.cards.add(card);
        }
}
