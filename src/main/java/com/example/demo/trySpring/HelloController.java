package com.example.demo.trySpring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	private static final String selectQuery = "select id, name, age from users where id = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(
			// htmlのname要素と同じ指定で値が取れる
			@RequestParam("text1") String str, Model model) {

		// helloResponse画面にsampleとして値を渡せる
		model.addAttribute("sample", str);
		return "helloResponse";
	}

	@PostMapping("/helloDB")
	public String postRequestDB(
			// htmlのname要素と同じ指定で値が取れる
			@RequestParam("text1") int id, Model model) {

		List<Map<String, Object>> list;
		list = jdbcTemplate.queryForList(selectQuery, id);

		// helloResponse画面にsampleとして値を渡せる
		model.addAttribute("id", list.get(0).get("id"));
		model.addAttribute("name", list.get(0).get("name"));
		model.addAttribute("age", list.get(0).get("age"));
		return "helloResponseDB";
	}

}
