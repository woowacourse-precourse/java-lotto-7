package lotto.winning.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputWinningNumberView {
    private String inputWinningNumbers;
    private String inputBonusNumber;

    public String getInputWinningNumbers() {
        if (inputWinningNumbers == null) {
            System.out.println("당첨 번호를 입력해 주세요.");
            this.inputWinningNumbers = readLine();
            System.out.println();

            return inputWinningNumbers;
        }
        return inputWinningNumbers;
    }

    public String getInputBonusNumber() {
        if (inputBonusNumber == null) {
            System.out.println("보너스 번호를 입력해 주세요.");
            this.inputBonusNumber = readLine();
            System.out.println();

            return inputBonusNumber;
        }
        return inputBonusNumber;
    }

    public void setNullInputWinningNumbers() {
        this.inputWinningNumbers = null;
    }

    public void setNullInputBonusNumber() {
        this.inputBonusNumber = null;
    }
}
