package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLineWithBlank();
    }

    public String getInputWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLineWithBlank();
    }

    public String getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLineWithBlank();
    }

    private String readLineWithBlank() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
