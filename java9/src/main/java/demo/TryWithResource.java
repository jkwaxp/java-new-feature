package demo;

import java.io.*;

public class TryWithResource {

    public static void main(String[] args) {
        // 使用 try-with-resources 声明多个资源
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"))) {
            String line;
            while ((line = in.readLine()) != null && !line.equalsIgnoreCase("exit")) {
                out.write(line);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
