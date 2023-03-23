package com.platzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Now we can have an implementation of a dependency, using the implementation of another dependency too
public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    // We can also use logs in our beans
    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    // So we just inject the dependency we want to use too
    private MyBeanOperation myBeanOperation;

    public MyBeanWithDependencyImpl(MyBeanOperation myBeanOperation) {
        this.myBeanOperation = myBeanOperation;
    }

    @Override
    public void printWithDependency() {
        // We can use info logs to understand better our app
        LOGGER.info("The application entered into printWithDependency method");
        System.out.println("Let's show an operation of a bean with dependency:");
        int a = 2;
        int b = 3;

        // We can debug with the logs (we have to configure the logging level in the application properties)
        LOGGER.debug("The numbers to sum are a= " + a + ", b= " + b);
        System.out.println(myBeanOperation.sum(a, b));
    }
}
