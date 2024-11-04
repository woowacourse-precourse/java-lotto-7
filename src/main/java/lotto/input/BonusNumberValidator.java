package lotto.input;
import java.util.List;


import static lotto.enums.ErrorMessages.*;
import static lotto.enums.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.enums.PromptMessages.BONUS_NUMBER_INPUT;

public class BonusNumberValidator implements InputValidator<Integer, List<Integer>> {


    @Override
    public Integer validateInput(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateBonusNumberRange(bonusNumber);
            validateBonusNumberDuplication(bonusNumber, winningNumbers);
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    @Override
    public void displayPrompt() {
        System.out.println(BONUS_NUMBER_INPUT.getMessage());
    }


    private void validateBonusNumberRange(int bonusNumber) {
        if(bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue()){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumber) {
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
