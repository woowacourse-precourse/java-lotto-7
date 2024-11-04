package lotto;

import lotto.exception.lottoNumber.*;
import lotto.exception.lottoPrice.InvalidThousandUnitException;
import lotto.exception.lottoPrice.MinimumPriceException;
import lotto.exception.lottoPrice.NullPriceException;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Validator {
    public static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int MIN_PRICE = 1000;
    private static final int DIVISOR = 1000;

    public void isValidPrice(String input) {
        if (input.isEmpty()) {
            throw new NullPriceException();
        }
        int price = Integer.parseInt(input);
        checkMinimumPrice(price);
        checkIsDivisibleByThousand(price);
    }

    public void isValidLottoNumbers(String input) {
        if (input.isEmpty()) {
            throw new NullLottoNumberException();
        }
        checkIsExistsDelimiter(input);
        List<String> lottoNumbers = parseLottoNumbers(input);
        checkIsAllNumbers(lottoNumbers);
        checkAllValidRange(lottoNumbers);
        checkLottoCount(lottoNumbers);
        checkIsDistinct(lottoNumbers);
    }

    public void isValidBonusLottoNumber(String input, Lotto winningNumbers) {
        if (input.isEmpty()) {
            throw new NullLottoNumberException();
        }
        checkIsSingleNumber(input);
        checkIsNumber(input);
        int bonusNumber = Integer.parseInt(input);
        checkValidRange(bonusNumber);
        checkIsDuplicatedWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private void checkIsSingleNumber(String input) {
        if (input.contains(DELIMITER)) {
            throw new InvalidSingleBonusNumberException();
        }
    }

    private void checkIsDuplicatedWithWinningNumbers(int bonusNumber, Lotto winningNumbers) {
        List<Integer> winningLottoNumbers = winningNumbers.getLotto();
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new DuplicatedNumberException();
        }
    }

    private void checkValidRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new OutOfRangeNumberException();
        }
    }

    private void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    private List<String> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void checkIsDistinct(List<String> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new DuplicatedNumberException();
        }
    }

    private void checkLottoCount(List<String> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new InvalidLottoCountException();
        }
    }

    private void checkAllValidRange(List<String> lottoNumbers) {
        for (String currentNumber : lottoNumbers) {
            int number = Integer.parseInt(currentNumber);
            checkValidRange(number);
        }
    }

    private void checkIsAllNumbers(List<String> lottoNumbers) {
        for (String currentNumber : lottoNumbers) {
            checkIsNumber(currentNumber);
        }
    }

    private void checkIsExistsDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new NotFoundDelimiterException();
        }
    }

    private void checkIsDivisibleByThousand(int price) {
        if (price % DIVISOR != 0) {
            throw new InvalidThousandUnitException();
        }
    }

    private void checkMinimumPrice(int price) {
        if (price < MIN_PRICE) {
            throw new MinimumPriceException();
        }
    }

}
