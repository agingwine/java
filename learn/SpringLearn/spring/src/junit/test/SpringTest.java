package junit.test;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.racer.aop.service.*;
import com.racer.aop.service.impl.*;

public class SpringTest {

	@Test
	public void instanceSpring() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-aop-annotation.xml");
		MyInterceptor interceptor = (MyInterceptor)ctx.getBean("myInterceptor");
	    assertNotNull(interceptor);
		PersonService personService = (PersonServiceBean)ctx.getBean("personServiceBean");
		personService.save("xxx");

	}

}
