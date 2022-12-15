package decks.decksofgenshin.data;

import org.springframework.data.repository.CrudRepository;

import decks.decksofgenshin.Card;

public interface CardRepository 
         extends CrudRepository<Card, String> {
    
}
