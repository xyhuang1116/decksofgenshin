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
public class Chara {
    @Id
    private final String id;
    private final String codeName;
    private final String name;
    private final int hp;

    @Enumerated(EnumType.STRING)
    private final Element element;

    @Enumerated(EnumType.STRING)
    private final Weapon weapon;

    @Enumerated(EnumType.STRING)
    private final NationOrCamp nationOrCamp;

    private final String desc; // the description of the card
    // private final String desc2; // the description of the original object in this card

    public enum Element{
        CRYO, HYDRO, PYRO, ELECTRO, ANEMO, GEO, DENDRO
    }

    public enum Weapon{
        Bow, Sword, Claymore, Catalyst, Pole
    }

    public enum NationOrCamp{
        MONDSTADT, LIYUE, INAZUMA, SUMERU, FATUI, HILICHURL, MONSTER
    }
}
