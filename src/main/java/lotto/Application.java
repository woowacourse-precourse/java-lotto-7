package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000; // 로또 한 장 가격 정의

    public static void main(String[] args) {
        try {
            int amount = inputAndValidateAmount(); // 구입 금액 입력 및 검증
            // 이후 로또 구매 및 처리 로직...
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생 시 에러 메시지 출력
        }
    }

    // 구입 금액 입력 및 1,000원 단위 검증을 포함한 메서드
    private static int inputAndValidateAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine()); // 구입 금액 입력
                if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다."); // 1,000원 단위 확인
                }
                return amount; // 유효한 금액일 경우 반환
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요."); // 숫자가 아닌 입력에 대한 예외 처리
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효하지 않을 경우 에러 메시지 출력 후 다시 입력
            }
        }
    }
}
