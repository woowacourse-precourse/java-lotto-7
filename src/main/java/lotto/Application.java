package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String buyAmountInput = Console.readLine();

        int buyAmount = Integer.parseInt(buyAmountInput);

        int lottoCount = buyAmount / 1000;
    }
}
