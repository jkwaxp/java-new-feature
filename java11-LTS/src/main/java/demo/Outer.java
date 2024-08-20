package demo;

import java.lang.reflect.Field;

public class Outer {
    private int num = 10;

    public class Inner{

        public void test() throws Exception {
            System.out.println("Outer int = " + num);
            // JDK 11 之前，如下代码报出异常：IllegalAccessException
            Class c = Outer.class ;
            Field f = c.getDeclaredField("num");
            f.set(Outer.this, 23);
            System.out.println("Outer int = " + num);
        }
    }

    public static void main(String[] args) throws Exception{
        new Outer().new Inner().test();
    }
}
