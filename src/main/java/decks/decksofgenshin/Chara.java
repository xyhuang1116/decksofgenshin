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
public class Chara {
    @Id
    private final String id;
    private final String name;
    private final String codeName;
    private final int hp;
    private final String element;
    private final String weapon;
    private final String nation;
    private final String desc; // the description of the card
    // private final String desc2; // the description of the original object in this card

    public enum Element{
        CRYO, HYDRO, PYRO, ELECTRO, ANEMO, GEO, DENDRO
    }

    public enum Weapon{
        Bow, Sword, Claymore, Catalyst, Pole, Other
    }

    public enum NationOrCamp{
        MONDSTADT, LIYUE, INAZUMA, SUMERU, FATUI, HILICHURL, MONSTER
    }
}
