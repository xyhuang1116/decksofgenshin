package decks.decksofgenshin.data;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import decks.decksofgenshin.Card;

public interface CardRepository 
         extends PagingAndSortingRepository<Card, String>, QuerydslPredicateExecutor<Card> {
}
