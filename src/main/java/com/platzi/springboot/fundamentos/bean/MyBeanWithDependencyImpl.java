package com.platzi.springboot.fundamentos.bean;

// Now we can have an implementation of a dependency, using the implementation of another dependency too
public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    // So we just inject the dependency we want to use too
    private MyBeanOperation myBeanOperation;

    public MyBeanWithDependencyImpl(MyBeanOperation myBeanOperation) {
        this.myBeanOperation = myBeanOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println("Let's show an operation of a bean with dependency:");
        int a = 2;
        int b = 3;
        System.out.println(myBeanOperation.sum(a, b));
    }
}
