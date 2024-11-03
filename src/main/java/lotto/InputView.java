package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static User createUser() {
        System.out.println("구입 금액을 입력해주세요.");
        String inputMoney = Console.readLine();
        return new User(inputMoney);
    }

    public static WinningLotto createWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return WinningLottoFactory.create(winningNumbers, bonusNumber);
    }
}
