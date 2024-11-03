package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public String inputMoney() {
        InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();
                inputMoneyValidator.validate(money);
                return money;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        InputLottoValidator inputLottoValidator = new InputLottoValidator();

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumber = Console.readLine();
                return inputLottoValidator.getWinningNumber(winningNumber);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();
                InputBonusValidator inputBonusValidator = new InputBonusValidator(bonusNumber);
                return inputBonusValidator.getBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
