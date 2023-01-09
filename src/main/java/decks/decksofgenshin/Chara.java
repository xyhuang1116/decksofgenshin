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

    private final String element;

    private final String weapon;

    private final String nationOrCamp;
}
