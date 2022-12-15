package decks.decksofgenshin;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Card {
    @Id
    private final String id;
    private final String cardName;
    private final int rarity;
    private final Type type;
    private final String sources;
    private final String desc1; // the description of the card
    private final String desc2; // the description of the original object in this card

    public enum Type{
        CHARACTER, WEAPON, TALENT
    }
}
