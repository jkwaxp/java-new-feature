package demo;

import jdk.jfr.Recording;

import java.io.File;

public class FlightRecorderDemo {

    public static void main(String[] args) throws Exception{
        // 启动记录
        Recording recording = new Recording();
        recording.start();

        // 模拟一些工作
        performWork();

        // 停止记录
        recording.stop();
        recording.dump(new File("recording.jfr").toPath());
        recording.close();
    }

    private static void performWork() {
        // 模拟一些计算或处理
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }
}
