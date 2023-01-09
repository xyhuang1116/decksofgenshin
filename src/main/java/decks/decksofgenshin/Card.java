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

    private final String type;

    private final String subType;

    private final String tag;
}
