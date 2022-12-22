package decks.decksofgenshin.data;

import org.springframework.data.repository.CrudRepository;

import decks.decksofgenshin.Chara;

public interface CharaRepository 
         extends CrudRepository<Chara, String> {
    
}
