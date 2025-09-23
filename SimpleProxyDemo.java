// Step 1: Define interface
interface MyInterface {
    void sayHello(String name);
}

// Step 2: Real implementation
class MyClass implements MyInterface {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

// Step 3: Proxy class
class MyProxy implements MyInterface {
    private MyInterface realObject;

    public MyProxy(MyInterface realObject) {
        this.realObject = realObject;
    }

    public void sayHello(String name) {
        System.out.println("[LOG] Before calling sayHello");
        realObject.sayHello(name); // call real method
        System.out.println("[LOG] After calling sayHello");
    }
}

// Step 4: Main class
public class SimpleProxyDemo {
    public static void main(String[] args) {
        MyInterface real = new MyClass();
        MyInterface proxy = new MyProxy(real);

        proxy.sayHello("Yogasri");
    }
}
