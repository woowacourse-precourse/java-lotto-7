package lotto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lotto.back.BackApplication;
import lotto.front.FrontApplication;

public class Application {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(1);


    public static void main(String[] args) {
        Thread frontThread = new Thread(FrontApplication::run);
        EXECUTOR_SERVICE.submit(frontThread);

        // 백엔드 스레드 분리 시 테스트의 random 임의 지정이 적용되지 않음
        // 따라서 백엔드 애플리케이션이 frontApplication.run() 메서드가 실행된 후에 존재해야 함
        BackApplication.run();

        try {
            frontThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
