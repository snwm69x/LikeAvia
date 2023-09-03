package com.sneg.likevavo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sneg.likevavo.config.BeanTestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
class LikevavoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private BeanTestConfig beanTestConfig;

	@Test
	void contextLoads() {
		List<String> beans = beanTestConfig.returnBeans();
		int beansSize = beans.size();
		boolean isOk = false;
		for (String bean : beans) {
			if(applicationContext.containsBean(bean)) {
				beansSize--;
				// System.out.println("Bean " + bean + " working fine");
			} else {
				System.out.println("Bean " + bean + " not found");
			}
		}
		if(beansSize == 0) {
			isOk = true;
			System.out.println("All beans in context : " + isOk);
			assert(isOk);
		} else {
			assert(isOk);
		}
		
	}

}
