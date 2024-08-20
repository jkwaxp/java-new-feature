package demo;

import java.util.Base64;

public class Base64Demo {

    public static void main(String[] args) {
        byte[] data = "12345678".getBytes();

        String base64Str = Base64.getEncoder().encodeToString(data);
        System.out.println(base64Str);
        byte[] bytes = Base64.getDecoder().decode(base64Str);
        System.out.println(new String(bytes));
    }
}
