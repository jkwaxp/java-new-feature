package demo;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesDemo {

    public static void main(String[] args) throws Exception{
        Path path = Path.of(System.getProperty("user.dir"), "java11-LTS", "demo.txt");

        Files.writeString(path, "abc", StandardOpenOption.WRITE);
        System.out.println(Files.readString(path));

        Files.writeString(path, "def", StandardOpenOption.APPEND);
        System.out.println(Files.readString(path, Charset.defaultCharset()));

        Files.writeString(path, "xyz", Charset.forName("GBK"), StandardOpenOption.TRUNCATE_EXISTING);
        Path path2 = Path.of(URI.create("file:///" + System.getProperty("user.dir").replace(File.separator, "/") + "/java11-LTS" + "/demo.txt"));
        System.out.println(Files.readString(path2));
    }
}
