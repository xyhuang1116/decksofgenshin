package decks.decksofgenshin;

import javax.persistence.*;

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
    private final String codeName;
    private final String name;
    private final int cost;

    @Enumerated(EnumType.STRING)
    private final Type type;

    @Enumerated(EnumType.STRING)
    private final SubType subType;

    @Enumerated(EnumType.STRING)
    private final Tag tag;

    public enum Type{
        EQUIP, SUPPORT, EVENT
    }

    public enum SubType{
        TALENT, WEAPON, ARTIFACT, PLACE, COMPANION, ITEM, RESONANCE, NORMAL, FOOD
    }

    public enum Tag{
        CRYO, HYDRO, PYRO, ELECTRO, ANEMO, GEO, DENDRO, BOW, SWORD, CLAYMORE, CATALYST, POLE, MONSTER
    }
}
