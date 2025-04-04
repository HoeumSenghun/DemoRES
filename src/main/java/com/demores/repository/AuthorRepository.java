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
}
