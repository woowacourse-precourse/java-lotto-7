package lotto.validator;

import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;


public class BonusNumber extends Validator {
    private final List<Integer> luckyNumbers;
    private int bonusNumber;

    public BonusNumber(List<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public BonusNumber processSetBonusNumber() {
        String request = InputUtils.retryRequest(Input.request(Input.BONUS_NUMBER_PROMPT), this::validate);
        this.bonusNumber = Integer.parseInt(request);

        return this;
    }

    @Override
    protected Boolean validate(String request) {
        List<Integer> numbers = new ArrayList<>(luckyNumbers);
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
