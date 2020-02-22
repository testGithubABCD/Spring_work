package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	HelloService helloService;

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

		Employee employee = helloService.findOne(id);

		// helloResponse画面にsampleとして値を渡せる
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());
		return "helloResponseDB";
	}

}
