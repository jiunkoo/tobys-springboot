package tobyspring.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

	@Autowired
	private HelloRepository helloRepository;

	@Test
	void findHelloFailed() {

		assertThat(helloRepository.findHello("Toby")).isNull();
	}

	@Test
	void increaseCount() {

		assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

		helloRepository.increaseCount("Toby");
		assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

		helloRepository.increaseCount("Toby");
		assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
	}
}
