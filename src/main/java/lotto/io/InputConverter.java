package lotto.io;

import java.util.Arrays;
import java.util.List;

import lotto.lotto.LottoAmount;
import lotto.lotto.LottoNumber;
import lotto.lotto.WiningNumbers;

public class InputConverter {

    public LottoAmount convertToLottoAmount(String amount) {
        return new LottoAmount(convertToInteger(amount));
    }

    public WiningNumbers convertToWiningNumbers(String[] splitNumbers) {
        List<Integer> numbers = Arrays.stream(splitNumbers)
                .map(this::convertToInteger)
                .toList();
        return new WiningNumbers(numbers);
    }

    public LottoNumber convertToBonusNumber(String number) {
        return new LottoNumber(convertToInteger(number));
    }

    private int convertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
