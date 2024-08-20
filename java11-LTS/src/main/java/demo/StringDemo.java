package demo;

public class StringDemo {

    public static void main(String[] args) {
        //去掉首尾空格
        System.out.println(" ABC ".strip());
        //去掉头部空格
        System.out.println(" ABC ".stripLeading());
        //去掉尾部空格
        System.out.println(" ABC ".stripTrailing());
        //是否空白字符串
        System.out.println(" ".isBlank());
        //统计行数
        System.out.println("A\nB\nC\n".lines().count());
        //复制 count 次
        System.out.println("TEST".repeat(2));
    }
}
