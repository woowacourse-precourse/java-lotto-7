package view;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;

public class InputViewImpl implements InputView {
    @Override
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        return winningNumbers;
    }

    @Override
    public String inputBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();

        return bonusNumber;
    }
}
