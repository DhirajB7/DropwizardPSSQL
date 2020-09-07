package BookApp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import BookApp.core.Book;

public class BookBodyReader implements MessageBodyReader<Book> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub

		return type == Book.class;
	}

	@Override
	public Book readFrom(Class<Book> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		System.out.println("1111111111111111111111111111111");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(entityStream))) {
			
			int id = Integer.valueOf(br.readLine());
			
			String name = br.readLine();
			
			String author = br.readLine();
			
			double price = Double.valueOf(br.readLine());
			
			Book book = new Book(id, name, author, price);
			
			return book;
			
		}catch (Exception e) {
			
			System.out.println("========================================="+e.getMessage());
			
			return null;
		}
	}

}
