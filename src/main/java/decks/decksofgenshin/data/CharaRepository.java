package decks.decksofgenshin.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import decks.decksofgenshin.Chara;

public interface CharaRepository 
         extends PagingAndSortingRepository<Chara, String> {
}
