package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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






}
