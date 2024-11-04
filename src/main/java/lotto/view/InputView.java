package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.dto.WinningLottoForm;
import lotto.domain.dto.MoneyForm;

public class InputView {
    public MoneyForm createMoneyForm() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String inputMoney = Console.readLine();
                System.out.println();
                return new MoneyForm(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLottoForm createWinningLottoForm() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbers = Console.readLine();
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();
                System.out.println();
                return new WinningLottoForm(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
