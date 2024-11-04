package lotto.common;

import java.util.function.Supplier;

public class Transaction {

    public <T> T execute(Supplier<T> supplier) {
        int retry = 10;

        while (retry > 0) {
            try {
                retry--;
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }

        throw new IllegalArgumentException("[ERROR] 10회 이상 잘못된 입력을 시도했습니다. 프로그램을 종료합니다.");
    }
}
