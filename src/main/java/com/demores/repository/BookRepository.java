package com.demores.repository;

import com.demores.model.dto.request.BookRequest;
import com.demores.model.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("""
    SELECT * FROM books
""")
    @Results(id = "bookMapper", value = {
        @Result(property = "bookId", column = "book_id"),
        @Result(property = "bookName", column = "name"),
        @Result(property = "publishDate", column = "published_date"),
        @Result(property = "authorId", column = "author_id")
    })
    List<Book> getAllBooks();

    @Select("""
    INSERT INTO books(name, published_date, author_id)
    VALUES (#{bookName}, #{publishDate}, #{authorId})
    RETURNING *
""")
    @ResultMap("bookMapper")
    Book addBook(BookRequest bookRequest);

    @Select("""
    SELECT * FROM books
    WHERE book_id = #{bookId}
""")
    @ResultMap("bookMapper")
    Book getBookById(Integer bookId);

    @Select("""
    UPDATE books
    SET name=#{request.bookName}, published_date=#{request.publishDate}, author_id=#{request.authorId}
    WHERE book_id=#{bookId}
    RETURNING *
""")
    @ResultMap("bookMapper")
    Book updateBook(@Param("bookId") Integer bookId, @Param("request") BookRequest bookRequest);

    @Select("""
    DELETE FROM books
    WHERE book_id = #{bookId}
    RETURNING *
""")
    @ResultMap("bookMapper")
    Book deleteBook(Integer bookId);
}
