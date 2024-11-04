package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000; // 로또 한 장 가격 정의

    private static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine()); // 구입 금액 입력
                validateAmount(amount); // 구입 금액 유효성 검사
                return amount; // 유효한 금액일 경우 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효하지 않을 경우 에러 메시지 출력 후 다시 입력
            }
        }
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다."); // 구입 금액이 1,000원 단위가 아니면 예외 발생
        }
    }
}
