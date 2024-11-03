package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PRINT_INPUT_MONEY ="구입금액을 입력해 주세요.";
    private static final String PRINT_INPUT_WINNING_NUMBER ="당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER ="보너스 번호를 입력해 주세요.";

    public String inputMoney() {
        InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
        while (true) {
            try {
                System.out.println(PRINT_INPUT_MONEY);
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
                System.out.println(PRINT_INPUT_WINNING_NUMBER);
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
                System.out.println(PRINT_INPUT_BONUS_NUMBER);
                String bonusNumber = Console.readLine();
                InputBonusValidator inputBonusValidator = new InputBonusValidator(bonusNumber);
                return inputBonusValidator.getBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
