package tobyspring.hello;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

	private final HelloService helloService;
	private final ApplicationContext applicationContext;

	public HelloController(HelloService helloService, ApplicationContext applicationContext) {

		this.helloService = helloService;
		this.applicationContext = applicationContext;

		System.out.println(applicationContext);
	}

	@GetMapping
	@ResponseBody
	public String hello(String name) {

		return helloService.sayHello(Objects.requireNonNull(name));
	}
}
