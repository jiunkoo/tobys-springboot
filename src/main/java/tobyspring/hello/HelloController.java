package tobyspring.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

	private final HelloService helloService;

	public HelloController(HelloService helloService) {

		this.helloService = helloService;
	}

	@GetMapping
	@ResponseBody
	public String hello(String name) {

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}

		return helloService.sayHello(name);
	}
}
