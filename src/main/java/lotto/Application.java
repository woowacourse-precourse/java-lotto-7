package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String buyAmountInput = Console.readLine();

            int buyAmount = Integer.parseInt(buyAmountInput);

            // 천원 단위가 아닌 경우 예외 발생
            if (buyAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 천원 단위만 입력 가능합니다.");
            }

            int lottoCount = buyAmount / 1000;
            System.out.println("로또 구매 개수: " + lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
