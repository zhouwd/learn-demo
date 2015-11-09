package com.joe.learn.dao;

import java.util.List;

import com.joe.learn.model.MybatisTest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface MybatisTestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mybatis_test
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    @Delete({
        "delete from mybatis_test",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mybatis_test
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    @Insert({
        "insert into mybatis_test (id, name, ",
        "age, birthday, ",
        "context)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{context,jdbcType=LONGVARBINARY})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Long.class)
    int insert(MybatisTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mybatis_test
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    @Select({
        "select",
        "id, name, age, birthday, context",
        "from mybatis_test",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARBINARY)
    })
    MybatisTest selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mybatis_test
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    @Select({
        "select",
        "id, name, age, birthday, context",
        "from mybatis_test"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<MybatisTest> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mybatis_test
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    @Update({
        "update mybatis_test",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "context = #{context,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MybatisTest record);
}