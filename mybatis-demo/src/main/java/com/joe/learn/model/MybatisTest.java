package com.joe.learn.model;

import java.util.Date;

public class MybatisTest {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_test.id
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_test.name
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_test.age
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_test.birthday
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_test.context
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    private byte[] context;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_test.id
     *
     * @return the value of mybatis_test.id
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_test.id
     *
     * @param id the value for mybatis_test.id
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_test.name
     *
     * @return the value of mybatis_test.name
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_test.name
     *
     * @param name the value for mybatis_test.name
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_test.age
     *
     * @return the value of mybatis_test.age
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_test.age
     *
     * @param age the value for mybatis_test.age
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_test.birthday
     *
     * @return the value of mybatis_test.birthday
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_test.birthday
     *
     * @param birthday the value for mybatis_test.birthday
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_test.context
     *
     * @return the value of mybatis_test.context
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public byte[] getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_test.context
     *
     * @param context the value for mybatis_test.context
     *
     * @mbggenerated Tue Nov 03 22:54:03 CST 2015
     */
    public void setContext(byte[] context) {
        this.context = context;
    }
}