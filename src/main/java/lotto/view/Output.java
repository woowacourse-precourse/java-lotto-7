package lotto.view;

import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;
import lotto.view.convertor.Convertor;

import static lotto.common.Instruction.INPUT_BONUS_NUMBER;
import static lotto.common.Instruction.INPUT_MONEY;
import static lotto.common.Instruction.INPUT_WIN_NUMBERS;
import static lotto.common.Instruction.SHOW_RESULT;

public class Output {
    private final Convertor convertor;

    public Output(Convertor convertor) {
        this.convertor = convertor;
    }

    public void inputMoney() {
        System.out.println();
        System.out.println(INPUT_MONEY.getMessage());
    }

    public void inputWinNumbers() {
        System.out.println();
        System.out.println(INPUT_WIN_NUMBERS.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void purchaseSign(UserLotto userLotto) {
        System.out.println();
        System.out.println(convertor.getPurchaseSign(userLotto));
    }

    public void userLottos(UserLotto userLotto) {
        System.out.println(convertor.getUserLottos(userLotto));
    }

    public void matchResult(MatchResponse matchResponse) {
        System.out.println(SHOW_RESULT.getMessage());
        System.out.println(convertor.getMatchResult(matchResponse));
    }

    public void message(String message) {
        System.out.println(message);
    }
}
