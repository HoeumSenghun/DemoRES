package com.demores.repository;

import com.demores.model.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorRepository {
    @Select("""
    SELECT * FROM authors
""")
    @Results(id = "authorMapper", value = {
        @Result(property = "id", column = "author_id")
    })
    List<Author> getAllAuthors();
}
