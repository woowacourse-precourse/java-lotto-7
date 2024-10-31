package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getPriceInput() {
        printInputPrice();
        return inputPrice();
    }

    public String getWinningNumbersInput() {
        printInputWinningNumbers();
        return inputWinningNumbers();
    }

    public int getBonusNumberInput() {
        printInputBonusNumber();
        return inputBonusNumber();
    }

    private void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }

    private void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String inputWinningNumbers() {
        return Console.readLine();
    }

    private void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
