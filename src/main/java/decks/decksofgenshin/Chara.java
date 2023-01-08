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

    public enum Element{
        CRYO, HYDRO, PYRO, ELECTRO, ANEMO, GEO, DENDRO
    }

    public enum Weapon{
        BOW, SWORD, CLAYMORE, CATALYST, POLE
    }

    public enum NationOrCamp{
        MONDSTADT, LIYUE, INAZUMA, SUMERU, FATUI, HILICHURL, MONSTER
    }
}
