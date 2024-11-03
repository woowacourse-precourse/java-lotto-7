package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int buyMoney() {

        String buy;

        while(true) {

            System.out.println("구입금액을 입력해 주세요.");
            buy = Console.readLine();  // 구입 금액

            try {
                validateAmount(buy); // 구입 금액 검증
                break; // 유효한 입력일 경우 while 종료
            }
            
            catch (Exception e) {
                System.out.println(e.getMessage()); // 예외 메시지만 출력
            }}

        return Integer.parseInt(buy);
    }

    // 구입 금액이 유효한지 검증
    private static void validateAmount(String input) {

        try {
            int amount = Integer.parseInt(input); // 숫자로 변환
            if (amount % 1000 != 0) { // 1,000원 단위가 아닐 시 예외 처리
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요."); // 숫자가 아닐 경우 예외 메시지 출력
        }
    }
}
