package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberSeparatorTest {

    private static final String DEFAULT_DELIMITER = ",";

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,3,5,7,9,11", "5,15,20,35,40,45"})
    void 입력받은_당첨번호를_구분자를_기준으로_분리하는지_검증(String winningNumbers) {
        String[] separatededLottoNumbers = WinningNumberSeparator.separatedLottoNumbers(winningNumbers);

        String[] splitLottoNumbers = winningNumbers.split(DEFAULT_DELIMITER);

        Assertions.assertArrayEquals(separatededLottoNumbers, splitLottoNumbers);
    }

}
