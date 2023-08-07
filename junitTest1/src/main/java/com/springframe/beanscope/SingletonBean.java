package com.springframe.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

    private final PrototypeBean prototypeBean;

   @Autowired
    public SingletonBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public void usePrototypeBean() {
        prototypeBean.performAction();
    }
}
