package functions;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;

public class UserInput {

    InputValidation validation = new InputValidation();

    public int purchaseToNumberOfTickets() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchase = Console.readLine();

            try {
                return validation.checkNumberOfTickets(purchase) / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    public Lotto winningNumber() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumberBeforeCheck = Console.readLine();

            try {
                return new Lotto(validation.checkWinningNumber(winningNumberBeforeCheck));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    public int bonusNumber(List<Integer> winningNumber) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberBeforeCheck = Console.readLine();

            try {
                return validation.checkBonusNumber(bonusNumberBeforeCheck,
                        winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

}
