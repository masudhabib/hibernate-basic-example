package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestAppJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp_schema", "root", "welcome1");
			statement = connection.createStatement();
			
			/*String sqlStatement = "CREATE TABLE myapp_schema.author("
					+ "id bigint(20) not null, "
					+ "last_name varchar(40) not null, "
					+ "PRIMARY KEY (id)"
					+ ");";*/
			
			//String sqlStatement = "INSERT INTO myapp_schema.author (id, last_name) values(1003, 'Watson');";
			
			String sqlStatement = "SELECT * FROM myapp_schema.author";
			
			//int i = statement.executeUpdate(sqlStatement);
			
			
			ResultSet resultSet = statement.executeQuery(sqlStatement);
			
			ArrayList<Author> authors = new ArrayList<>();
			while(resultSet.next()){
				Author author = new Author();
				author.setId(resultSet.getLong("id"));
				author.setLastname(resultSet.getString("last_name"));
				
				authors.add(author);
			}
			
			//System.out.println(resultSet);
			
			List<Author> newListOfAuthor = authors.stream().filter(au->{return au.getId()>= 1002;}).collect(Collectors.toList());
			for(Author au : newListOfAuthor){
				System.out.println(au);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
