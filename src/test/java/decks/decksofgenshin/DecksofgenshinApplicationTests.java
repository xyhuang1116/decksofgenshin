package decks.decksofgenshin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.sql.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.boot.test.context.SpringBootTest;

import decks.decksofgenshin.data.CharaRepository;

@SpringBootTest
class DecksofgenshinApplicationTests {

	@Autowired
	private CharaRepository charaRepository;

	@Autowired 
	private DataSource dataSource;

	// @Test
	// public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails()
	//  throws SQLException {
	// 	assertEquals(dataSource.getClass().getName(), "com.zaxxer.hikari.HikariDataSource");
	// 	assertEquals(dataSource.getConnection().getMetaData().getDatabaseProductName(), "H2");
	// }

	@Test
	public void whenShowTablesThenExpectOneTable() throws SQLException {
		ResultSet rs = null;
		int noOfCharacters = 0;

		try(PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM CHARA")) {
			rs = ps.executeQuery();
			while(rs.next()) {
				noOfCharacters = rs.getInt(1);
			}
			assertThat(noOfCharacters).isEqualTo(27L);
		}
		finally {
			if(rs != null) {
				rs.close();
			}
		}
	}

	@Test
	void givenDataAvailableWhenLoadFirstPageThenGetFiveCharas(){
		// Pageable pageable = PageRequest.of(0, 5);
		// assertThat(charaRepository.findAll(pageable)). hasSize(5);
		// assertThat(pageable.getPageNumber()).isEqualTo(0);

		// Pageable nextPageable = pageable.next();
		// assertThat(charaRepository.findAll(nextPageable)).hasSize(5);
		// assertThat(nextPageable.getPageNumber()).isEqualTo(1);

		// Pageable newPageable = PageRequest.of(5, 2);  // 27 charas divided into 5 pages, the last page has 2 items.
		// assertThat(charaRepository.findAll(newPageable)). hasSize(2);
		// assertThat(newPageable.getPageNumber()).isEqualTo(5); // If it's the last page, getPageNumber will return the last apge itself.

		// Pageable pageable = PageRequest.of(0, 12);
		// assertThat(charaRepository.findAll(pageable)). hasSize(12);
		// assertThat(pageable.getPageNumber()).isEqualTo(0);

		Pageable pageable = PageRequest.of(0, 6);
		Pageable nextPageable = pageable.next();

		Condition<Chara> FirstCourseCondition = new Condition<Chara>(){
			@Override
			public boolean matches(Chara chara){
				return chara.getId() == "n330525" && chara.getName().equals("Barbara");
			}
		};
		assertThat(charaRepository.findAll(nextPageable)).hasSize(6);
		assertThat(charaRepository.findAll(nextPageable)).first().has(FirstCourseCondition);
		
	}
}