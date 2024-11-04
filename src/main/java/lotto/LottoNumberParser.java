package lotto;

import lotto.enums.LottoConfig;
import lotto.exception.ParserExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class LottoNumberParser implements Parser<String, List<Integer>> {
    @Override
    public List<Integer> parse(String givenInput) {
        String[] lottoNumbers = givenInput.split(",");
        return convert2lottoNumbers(lottoNumbers);
    }

    private List<Integer> convert2lottoNumbers(String[] givenNumbers) {
        try {
            return Arrays.stream(givenNumbers).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ParserExceptionMessage.NUMBER_FORMAT_INCORRECT.getMessage());
        }
    }
}
