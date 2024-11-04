package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public User createUser() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String inputMoney = Console.readLine();
                System.out.println();
                return new User(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto createWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbers = Console.readLine();
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();
                System.out.println();
                return WinningLottoFactory.create(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
