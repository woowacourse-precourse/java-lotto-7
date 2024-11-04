package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class LottoInputParser {
    private final LottoConfig lottoConfig;

    public LottoInputParser(LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER.getMessage());
        }
    }

    public List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(lottoConfig.getNumbersDelimiter()))
                .map(this::parseInt)
                .collect(Collectors.toList());
    }
}
