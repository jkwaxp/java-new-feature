package demo;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamsExample {

    public static void main(String[] args) {
        // 创建一个提交发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 创建一个订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1); // 请求一个数据项
            }

            @Override
            public void onNext(String item) {
                System.out.println("Received: " + item + Thread.currentThread().getName());
                subscription.request(1); // 请求下一个数据项
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };

        // 注册订阅者
        publisher.subscribe(subscriber);

        // 发布数据
        publisher.submit("Hello");
        publisher.submit("Reactive");
        publisher.submit("Streams");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭发布者
        publisher.close();
    }
}
