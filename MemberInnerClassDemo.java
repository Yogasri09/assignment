class OuterClass {
    private String message = "Hello from Outer Class!";
    class InnerClass {
        void displayMessage() {
            System.out.println("Message from Inner Class: " + message);
        }
    }
}
public class MemberInnerClassDemo {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();        
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.displayMessage();
    }
}
