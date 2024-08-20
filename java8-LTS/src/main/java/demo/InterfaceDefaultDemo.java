package demo;

public class InterfaceDefaultDemo {

    public static void main(String[] args) {
        A.staticPrint();

        new B().print();

        new C().print();
        C.staticPrint();
    }

    interface A{
        default void print() {
            System.out.println("this is A");
        }

        static void staticPrint(){
            System.out.println("this is A static");
        }
    }

    static class B implements A{

    }

    static class C implements A{
        public void print() {
            System.out.println("this is C");
        }

        public static void staticPrint(){
            System.out.println("this is C static");
        }
    }
}
