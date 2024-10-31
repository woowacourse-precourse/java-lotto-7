package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private void printRequestingLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private int getLottoPurchaseCount(String userInput) {
        int money = Validator.validateMoneyInput(userInput);
        return money / 1000;
    }
}
