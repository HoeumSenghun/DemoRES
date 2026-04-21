package com.demores.repository;

import com.demores.model.dto.request.CategoryRequest;
import com.demores.model.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("""
    SELECT * FROM categories
""")
    @Results(id = "categoryMapper", value = {
        @Result(property = "categoryId", column = "category_id"),
        @Result(property = "categoryName", column = "name")
    })
    List<Category> getAllCategories();

    @Select("""
    SELECT * FROM categories
    ORDER BY category_id
    LIMIT #{limit} OFFSET #{offset}
""")
    @ResultMap("categoryMapper")
    List<Category> getAllCategoriesPaged(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
    INSERT INTO categories(name)
    VALUES (#{categoryName})
    RETURNING *
""")
    @ResultMap("categoryMapper")
    Category addCategory(CategoryRequest categoryRequest);

    @Select("""
    SELECT * FROM categories
    WHERE category_id = #{categoryId}
""")
    @ResultMap("categoryMapper")
    Category getCategoryById(Integer categoryId);

    @Select("""
    UPDATE categories
    SET name=#{request.categoryName}
    WHERE category_id=#{categoryId}
    RETURNING *
""")
    @ResultMap("categoryMapper")
    Category updateCategory(@Param("categoryId") Integer categoryId, @Param("request") CategoryRequest categoryRequest);

    @Select("""
    DELETE FROM categories
    WHERE category_id = #{categoryId}
    RETURNING *
""")
    @ResultMap("categoryMapper")
    Category deleteCategory(Integer categoryId);
}

