package com.demores.repository;

import com.demores.model.entity.Book;
import com.demores.model.entity.BookCategory;
import com.demores.model.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookCategoryRepository {
    @Select("""
    INSERT INTO book_category(book_id, category_id)
    VALUES (#{bookId}, #{categoryId})
    ON CONFLICT (book_id, category_id) DO NOTHING
    RETURNING book_id, category_id
""")
    @Results(id = "bookCategoryMapper", value = {
        @Result(property = "bookId", column = "book_id"),
        @Result(property = "categoryId", column = "category_id")
    })
    BookCategory assignCategoryToBook(@Param("bookId") Integer bookId, @Param("categoryId") Integer categoryId);

    @Select("""
    DELETE FROM book_category
    WHERE book_id = #{bookId} AND category_id = #{categoryId}
    RETURNING book_id, category_id
""")
    @ResultMap("bookCategoryMapper")
    BookCategory unassignCategoryFromBook(@Param("bookId") Integer bookId, @Param("categoryId") Integer categoryId);

    @Select("""
    SELECT c.category_id, c.name
    FROM categories c
    INNER JOIN book_category bc ON bc.category_id = c.category_id
    WHERE bc.book_id = #{bookId}
    ORDER BY c.category_id
""")
    @Results(id = "categoryMapperForJoin", value = {
        @Result(property = "categoryId", column = "category_id"),
        @Result(property = "categoryName", column = "name")
    })
    List<Category> getCategoriesByBookId(Integer bookId);

    @Select("""
    SELECT b.book_id, b.name, b.published_date, b.author_id
    FROM books b
    INNER JOIN book_category bc ON bc.book_id = b.book_id
    WHERE bc.category_id = #{categoryId}
    ORDER BY b.book_id
""")
    @Results(id = "bookMapperForJoin", value = {
        @Result(property = "bookId", column = "book_id"),
        @Result(property = "bookName", column = "name"),
        @Result(property = "publishDate", column = "published_date"),
        @Result(property = "authorId", column = "author_id")
    })
    List<Book> getBooksByCategoryId(Integer categoryId);
}

