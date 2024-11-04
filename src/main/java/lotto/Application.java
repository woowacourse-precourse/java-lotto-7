package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]"; // 예외 메시지 상수 정의
    private static final int PRICE_LOTTO = 1000;
    public static void main(String[] args) {
        try {
            // 기본 예외 처리 구조 추가
            int totalAmount = getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.print("로또 구입 금액을 입력하세요: ");
        try {
            int amount = Integer.parseInt(Console.readLine().trim());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % PRICE_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

}
