package decks.decksofgenshin;

import lombok.Data;

@Data
public class Card {
    private final String cardName;
    private final String id;
    private final int rarity;
    private final Type type;
    private final String sources;
    private final String desc1; // the description of the card
    private final String desc2; // the description of the original object in this card

    public enum Type{
        CHARACTER, WEAPON, TALENT
    }
}
