package lotto.validator;

import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.Set;


public class BonusNumber extends Validator implements LottoConstants {
    WinningNumbers winningNumbers;
    private int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void processSetBonusNumber() {
        String request = InputUtils.retryRequest(Input.request(Input.BONUS_NUMBER_PROMPT), this::validate);

        this.bonusNumber = Integer.parseInt(request);
    }

    @Override
    protected Boolean validate(String request) {
        Set<Integer> numbers = winningNumbers.getWinningNumbers();
        int bonus;

        if (nonEmpty(Input.BONUS_NUMBER_PROMPT, request) &&
            isNumeric(Input.BONUS_NUMBER_PROMPT, request) &&
            isPositiveNumeric(Input.BONUS_NUMBER_PROMPT, request)) {

            bonus = Integer.parseInt(request);
            numbers.add(bonus);

            return isLottoNumberRange(Input.BONUS_NUMBER_PROMPT, bonus) &&
                   hasNoDuplicates(Input.BONUS_NUMBER_PROMPT, numbers);
        }
        return false;
    }

}
