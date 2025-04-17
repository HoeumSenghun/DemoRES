package com.demores.repository;

import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.entity.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {
    @Select("""
    SELECT * FROM authors
""")
    @Results(id = "authorMapper", value = {
        @Result(property = "authorId", column = "author_id"),
        @Result(property = "authorName", column = "name"),
        @Result(property = "authorGender", column = "gender")
    })
    List<Author> getAllAuthors();

    @Select("""
    INSERT INTO authors(name, gender) 
    VALUES ( #{authorName}, #{authorGender})
    RETURNING *
""")
    @ResultMap("authorMapper")
    Author addAuthor(AuthorRequest authorRequest);

    @Select("""
    SELECT * FROM authors
    WHERE author_id = #{authorId}
""")
    @ResultMap("authorMapper")
    Author getAuthorById(Integer authorId);

    @Select("""
    UPDATE authors
    SET name=#{request.authorName}, gender=#{request.authorGender}
    WHERE author_id=#{authorId}
    RETURNING *
""")
    @ResultMap("authorMapper")
    Author updateAuthor(@Param("authorId") Integer authorId,@Param("request") AuthorRequest authorRequest);
}
