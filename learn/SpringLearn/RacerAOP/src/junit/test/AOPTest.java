package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.racer.aop.CGlibProxyFactory;
import com.racer.aop.JDKProxyFactory;
import com.racer.service.PersonService;
import com.racer.service.impl.PersonServiceBean;

public class AOPTest {

	@Test
	public void proxyTest() {
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService serviceProxy=(PersonService)factory.createProxyInstance(new PersonServiceBean());
		serviceProxy.save("dd");
	}

	@Test
	public void cglibTest() {
		CGlibProxyFactory factory = new CGlibProxyFactory();
		PersonService serviceProxy=(PersonService)factory.createProxyInstance(new PersonServiceBean());
		serviceProxy.save("dd");
	}
}
