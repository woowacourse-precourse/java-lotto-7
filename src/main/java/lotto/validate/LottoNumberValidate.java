package lotto.validate;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Constants.*;

public class LottoNumberValidate {

    private final List<Integer> lottoNumber;

    public LottoNumberValidate(String numberString) {
        List<Integer> lottoNumber = parseNumber(splitNumberString(numberString));
        isRangeNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private List<String> splitNumberString(String numberString) {
        return List.of(numberString.split(","));
    }

    private List<Integer> parseNumber(List<String> list) {
        try {
            return list.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + WINNING_NUMBER_MUST_NUMBER);
        }
    }

    private void isRangeNumber(List<Integer> numberList) {
        if (numberList.stream().anyMatch((number) -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ERROR + WINNING_NUMBER_RANGE);
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
