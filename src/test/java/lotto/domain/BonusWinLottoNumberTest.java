package lotto.domain;

import lotto.model.winlotto.BasicWinLottoNumbers;
import lotto.model.winlotto.BonusWinLottoNumber;
import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusWinLottoNumberTest {

    BasicWinLottoNumbers basicNumbers =
            new BasicWinLottoNumbers("1,2,3,4,5,6");

    @Test
    @DisplayName("예외 메시지 : 입력 없음")
    void exceptionMessageTestEmptyInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusWinLottoNumber("", basicNumbers));
        assertEquals(ExceptionMessage.EMPTY_INPUT.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 공백 입력")
    void exceptionMessageTestContainsBlankInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusWinLottoNumber(" 22", basicNumbers));
        assertEquals(ExceptionMessage.BLANK_INPUT.toString(),
                exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "2000@"})
    @DisplayName("예외 메시지 : 숫자 아닌 문자 입력")
    void exceptionMessageTestContainsNotDigitInput(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusWinLottoNumber(input, basicNumbers));
        assertEquals(ExceptionMessage.NO_DIGIT_INPUT.toString(),
                exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10000"})
    @DisplayName("예외 메시지 : 숫자 아닌 문자 입력")
    void exceptionMessageTestOutRangeLottoNumber(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusWinLottoNumber(input, basicNumbers));
        assertEquals(ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지: 기본 당첨번호와 중복")
    void exceptionMessageTestDuplicateNumber() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusWinLottoNumber("1", basicNumbers));
        assertEquals(Constants.EXCEPTION_MESSAGE_PREFIX +
                "보너스 번호는 기본 당첨 번호와 중복되면 안 됩니다.",
                exception.getMessage());
    }

}
