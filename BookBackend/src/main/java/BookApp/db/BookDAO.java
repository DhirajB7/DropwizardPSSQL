package BookApp.db;

import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface BookDAO {
	
	 @SqlQuery("select name from books where id = :id")
	  String findNameById(@Bind("id") int id);
	 
	 @SqlQuery("select name from books")
	 List<String> findAllNames();

	 @SqlQuery("select author from books where id = :id")
	  String findAuthorNameById(@Bind("id") int id);
	 
	 @SqlQuery("select author from books")
	 List<String> findAllAuthorNames();
	 
	  @SqlUpdate("insert into books (id, name ,author ,price) values (:id, :name, :author, :price)")
	  boolean addToDB(@Bind("id") int id, @Bind("name") String name,@Bind("author") String author,@Bind("price") double price);
}

