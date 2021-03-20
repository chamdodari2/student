package student.dbcon; // db.properties 파일 내용중에 =를 기준으로 왼쪽에 있는게 key 오른쪽은 벨류임
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class JdbcConn {

	public static Connection getConnection() {		
		String propertiesPath = "db.properties";					//db.properties 파일 제목을 담기
		Connection con = null;

		try (InputStream in = ClassLoader.getSystemResourceAsStream(propertiesPath)) {	// 파일에 있는코드 쪼개서 가져올건데  매개변수인 propertiesPath 에 적힌파일 가져올거임
			Properties prop = new Properties();											//Properties 클래스를 이용해서 파일코드내용을  key=values로 읽어줄거임 
			prop.load(in); 																// 아까 스트림으로 가져온걸 담은 in을 prop로 다시 감싸준다. 
			con = DriverManager.getConnection(prop.getProperty("url"), prop);			//prop로 감싼내용중 키값 url에 해당되는 벨류를 가져온다 

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;																		//con에 있는 주소(?) 리턴
	}

}
