package decks.decksofgenshin.data;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import decks.decksofgenshin.Chara;

public interface CardRepository 
         extends PagingAndSortingRepository<Chara, String>, QuerydslPredicateExecutor<Chara> {
}
