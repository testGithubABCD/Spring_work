package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String selectQuery = "select id, name, age from users where id = ?";

	public Map<String, Object> findOne(int id) {
		Map<String, Object> employee = jdbcTemplate.queryForMap(selectQuery, id);
		return employee;
	}

}
