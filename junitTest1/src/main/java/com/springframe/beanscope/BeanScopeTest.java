package com.springframe.beanscope;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class BeanScopeTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testBeanScopesAndLifecycle() {
        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);

        assertNotSame(prototypeBean1, prototypeBean2);

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

        assertSame(singletonBean1, singletonBean2);

        singletonBean1.usePrototypeBean();
        singletonBean2.usePrototypeBean();
    }
}
