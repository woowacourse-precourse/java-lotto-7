package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]"; // 예외 메시지 상수 정의

    public static void main(String[] args) {
        try {
            // 기본 예외 처리 구조 추가
            int totalAmount = getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        // 로또 구입 금액을 입력받는 메서드
        return 0;
    }
}
