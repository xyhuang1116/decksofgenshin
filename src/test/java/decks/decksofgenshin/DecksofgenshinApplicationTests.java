package decks.decksofgenshin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecksofgenshinApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails()
	 throws SQLException {
		assertEquals(dataSource.getClass().getName(), "com.zaxxer.hikari.HikariDataSource");
		assertEquals(dataSource.getConnection().getMetaData().getDatabaseProductName(), "H2");
	}
	
	@Test
	public void whenCountAllCharactersThenExpectTwentySevenCharas() throws SQLException {
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

}
