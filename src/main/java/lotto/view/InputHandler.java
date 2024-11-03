package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constants;
import lotto.validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public int getAmountInput() throws IllegalArgumentException {
        String input = Console.readLine();
        validateInputAmount(input);
        return parseInt(input);
    }


    public void validateInputAmount(String input) throws IllegalArgumentException {
        if (InputValidator.isNullOrBlank(input)) {
            throw new IllegalArgumentException(Constants.ERROR_NO_BLANK_OR_NULL);

        }
        if (!InputValidator.isValidFormatForMoney(input)) {
            throw new IllegalArgumentException(Constants.ERROR_MORE_THAN_THOUSAND);
        }
        int numericInput = parseInt(input);
        if (!InputValidator.isThousandUnit(numericInput)) {
            throw new IllegalArgumentException(Constants.ERROR_THOUSAND_UNIT);
        }
    }

    public List<Integer> getLottoNumber() {

        String input = Console.readLine();

        validateLottoInput(input);

        return convertToNumberList(input);

    }

    private void validateLottoInput(String lottoNumber) {
        if (InputValidator.isNullOrBlank(lottoNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_NO_BLANK_OR_NULL);
        }
        if (!InputValidator.isValidFormatForLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_COMMA_WITH_NUMBERS);
        }
        String[] splitNumbers = lottoNumber.split(Constants.DELIMITER_COMMA);

        if (!InputValidator.isCountSix(splitNumbers)) {
            throw new IllegalArgumentException(Constants.ERROR_NUMBER_MUST_BE_SIX);
        }
        if (!InputValidator.isUniqueNumbers(splitNumbers)) {
            throw new IllegalArgumentException(Constants.ERROR_NO_DUPLICATE);
        }
        if (!InputValidator.isInRange(splitNumbers)) {
            throw new IllegalArgumentException(Constants.ERROR_NUMBER_BETWEEN_ONE_TO_FORTY_FIVE);
        }
    }

    public int getBonusNumber(List<Integer> lottoNumbers) {
        String stringBonusNumber = Console.readLine();
        validateBonusNumber(stringBonusNumber, lottoNumbers);
        return parseInt(stringBonusNumber);

    }

    private void validateBonusNumber(String bonusNumber, List<Integer> lottoNumber) {
        if (InputValidator.isNullOrBlank(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_NO_BLANK_OR_NULL);
        }
        if (!InputValidator.isNumeric(bonusNumber)) {
            throw new NumberFormatException(Constants.ERROR_FORMAT_IS_NUMBER);
        }
        if (!InputValidator.isUnique(bonusNumber, lottoNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_DUPLICATED_BONUS_NUMBER);
        }
        if (!InputValidator.isInRange(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_NUMBER_BETWEEN_ONE_TO_FORTY_FIVE);
        }
    }

    private List<Integer> convertToNumberList(String input) {
        return Arrays.stream(input.split(Constants.DELIMITER_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new NumberFormatException(Constants.ERROR_FORMAT_IS_NUMBER);
        }
    }
}
