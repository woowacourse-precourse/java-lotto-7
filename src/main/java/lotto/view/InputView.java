package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String FORMAT_ERROR_MESSAGE = ERROR_MESSAGE + "숫자만 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = ERROR_MESSAGE + "중복된 번호가 있습니다.";

    public Money inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        try {
            return Money.from(inputNumberToInt());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private int inputNumberToInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(FORMAT_ERROR_MESSAGE);
            return inputNumberToInt();
        }
    }

    public Lotto inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        try {
            return Lotto.createFromString(Console.readLine());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return inputWinningNumber();
        }
    }

    public LottoNumber inputBonusNumber(Lotto winningLotto) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            int number = inputNumberToInt();
            validBonusNumber(winningLotto, number);
            return LottoNumber.of(number);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    private void validBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContains(LottoNumber.of(bonusNumber))){
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
