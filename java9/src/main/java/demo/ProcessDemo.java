package demo;

import java.util.Optional;

public class ProcessDemo {

    public static void main(String[] args) {
        // 获取当前进程的句柄
        ProcessHandle currentProcess = ProcessHandle.current();

        // 打印当前进程的 PID
        System.out.println("Current Process ID: " + currentProcess.pid());

        ProcessHandle.allProcesses().forEach(e -> System.out.println(e.info().command().orElse("N/A")));

        // 获取进程信息
        ProcessHandle.Info info = currentProcess.info();
        System.out.println("Command: " + info.command().orElse("N/A"));
        System.out.println("Start Time: " + info.startInstant().orElse(null));

        // 获取子进程
        currentProcess.children().forEach(child -> {
            System.out.println("Child Process ID: " + child.pid());
        });
    }
}
