package lotto.view;

import static lotto.constant.LottoInputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.LottoInputMessage.INPUT_MONEY_MESSAGE;
import static lotto.constant.LottoInputMessage.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.LottoValidator;

public class InputView {

    private final LottoValidator lottoValidator;

    public InputView(LottoValidator lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    public String inputMoney() {
        while (true) {
            System.out.println(INPUT_MONEY_MESSAGE);
            String money = Console.readLine();
            try {
                lottoValidator.validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinnerNumbers() {
        while (true) {
            System.out.println();
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
            String winnerNumbers = Console.readLine();
            try {
                lottoValidator.validateWinnerLottoNumbers(winnerNumbers);
                return winnerNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputBonusNumber(List<Integer> winnerNumbers) {
        while (true) {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            String bonusNumber = Console.readLine();
            try {
                lottoValidator.validateBonusNumber(winnerNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
