package com.triarq.practice.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.triarq.practice.entity.Person;

@Repository
public class PersonDao {

	/*
	 * This is the sample demonstration of JDBCTemplate for retrieving data from DB
	 */

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// select * from person
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));

	}

	// find by ID
	/*
	 * public Person findById(Integer id) { return (Person)
	 * jdbcTemplate.queryForObject ("select * from person where id = ?", new
	 * BeanPropertyRowMapper(Person.class),new Object[]{id});
	 * 
	 * }
	 */

	public Person getById(Integer id) {
		return (Person) jdbcTemplate.queryForObject("select * from person where id =?",
				new BeanPropertyRowMapper(Person.class), new Object[] { id });
	}
	
	//find by name
	public List<Person> findByName(String name) {
	String sql = "select * from person where name='"+name+"';";
	List<Person> plist = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Person.class));
	return plist;
	}
	
	//delete by ID
	public int deleteById(Integer id) {
		return  jdbcTemplate.update("delete from person where id =?", new Object[] { id });
	}
	
	//insert into DB
	public int insertPerson(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?,?,?,?)", new Object[] {person.getId(), person.getName(), person.getLocation(), person.getBirth_date()});	
	}
	
	//update the record
		public int updatePerson(Person person) {
			return jdbcTemplate.update("update person set birth_date=?, location=?, name=? where id = ? ", new Object[] {person.getBirth_date(), person.getLocation(), person.getName(), person.getId()});	
		}
	
}
