package lotto;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.EnumManagement.ExceptionEnum;

public class Exception {
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final int DIVIDED_TOTAL_LOTTO_PURCHASE = 1000;
    private final int INPUT_MAX_LOTTO_NUMBER_SIZE = 6;
    private final int ONE_DAY_BUY_LOTTO_LIMIT = 100;

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int validateLottoPurchase(String input) {
        int returnLottoPurchase = 0;
        if(input.isEmpty()){
            throw new IllegalArgumentException(ExceptionEnum.NO_INPUT_DATA.getMessage());
        }
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ExceptionEnum.INPUT_NUMBER_IS_INTEGER.getMessage());
        }
        returnLottoPurchase = isDivide1000(Integer.parseInt(input));
        if(returnLottoPurchase/DIVIDED_TOTAL_LOTTO_PURCHASE > ONE_DAY_BUY_LOTTO_LIMIT) {
            throw new IllegalArgumentException(ExceptionEnum.ONE_DAY_LOTTO_LIMIT.getMessage());
        }
        return returnLottoPurchase;

    }

    public int validateBonusNumber(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ExceptionEnum.INPUT_NUMBER_IS_INTEGER.getMessage());
        }
        return Integer.parseInt(input);

    }

    public int isDivide1000(int inputNumber) {
        if (!(inputNumber % DIVIDED_TOTAL_LOTTO_PURCHASE == 0)) {
            throw new IllegalArgumentException(ExceptionEnum.LOTTO_PURCHASE_UNIT_1000.getMessage());
        }
        return inputNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionEnum.BONUS_NUMBER_RANGE_1TO45.getMessage());
        }
    }

    public List<Integer> parseLottoNumbers(String rawNumbers) {
        String[] rawNumberSplit = rawNumbers.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String numberInput : rawNumberSplit) {
            if (!isInteger(numberInput)) {
                throw new IllegalArgumentException(ExceptionEnum.ALL_LOTTO_NUMBER_IS_INTEGER.getMessage()); // 개선된 메시지
            }
            int number = Integer.parseInt(numberInput);
            lottoNumbers.add(number);
        }
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueLottoNumbers(numbers);
        validateLottoNumberRange(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != INPUT_MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionEnum.LOTTO_NUMBERS_SIZE_SIX.getMessage());
        }
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != INPUT_MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionEnum.LOTTO_NUMBERS_UNIQUE.getMessage());
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ExceptionEnum.LOTTO_NUMBER_RANGE_1TO45.getMessage());
            }
        }
    }
}
