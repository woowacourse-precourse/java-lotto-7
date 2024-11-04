package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessages;

public class Validator {

    public int validatePrice(String priceInput) {
        try {
            int price = Integer.parseInt(priceInput);
            if (price <= 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_UNDER_ZERO));
            }
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_NOT_IN_UNITS_OF_1000));
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_IS_NOT_STRING));
        }
    }

    public String validateInput(String lottoNumber) {
        // 숫자와 쉼표만 허용하는 정규식 검증
        validateDelimeterIsComma(lottoNumber);
        List<Integer> numbers = splitLottoNumber(lottoNumber);
        validateLottoElementsRange(numbers);
        int size = numbers.size();
        validateLottoNumberIsSix(size);
        validateUniqueLottoNumber(numbers, size);
        return lottoNumber;
    }
    public int validateNumber(int bonusNumber) {
        if (validateNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
        }
        return bonusNumber;
    }
    private static void validateUniqueLottoNumber(List<Integer> numbers, int size) {
        if (numbers.stream().distinct().toList().size() != size) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_LOTTO_NUMBER_IS_UNIQUE));
        }
    }

    private static void validateLottoNumberIsSix(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_LOTTO_NUMBER_IS_SIX));
        }
    }

    private static void validateDelimeterIsComma(String lottoNumber) {
        if (!lottoNumber.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_DELIMETER_ONLY_HAS_COMMA));
        }
    }

    private void validateLottoElementsRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (validateNumberRange(number)) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
            }
        }
    }



    private boolean validateNumberRange(int number) {
        return number < 1 || number > 45;
    }

    private List<Integer> splitLottoNumber(String lottoNumber) {

        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
