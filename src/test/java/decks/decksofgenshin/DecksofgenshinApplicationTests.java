package decks.decksofgenshin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.sql.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

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
	void givenDataAvailableWhenLoadFirstPageThenGetTwentySewenCharas(){
		Pageable pageable = PageRequest.of(0, 5);
		assertThat(charaRepository.findAll(pageable)). hasSize(5);
		assertThat(pageable.getPageNumber()).isEqualTo(0);

		Pageable nextPageable = pageable.next();
		assertThat(charaRepository.findAll(nextPageable)).hasSize(4);
		assertThat(nextPageable.getPageNumber()).isEqualTo(1);
	}
}