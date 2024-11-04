package lotto.domain;

import lotto.model.winlotto.BasicWinLottoNumbers;
import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicWinLottoNumbersTest {

    @Test
    @DisplayName("예외 메시지 : 입력 없음")
    void exceptionMessageTestEmptyInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BasicWinLottoNumbers(""));
        assertEquals(ExceptionMessage.EMPTY_INPUT.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 공백 입력")
    void exceptionMessageTestBlankInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BasicWinLottoNumbers(" 10000"));
        assertEquals(ExceptionMessage.BLANK_INPUT.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 로또 숫자 개수 오류")
    void exceptionMessageTestCountNumberLotto() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BasicWinLottoNumbers("1,2,3,4,5"));
        assertEquals(Constants.EXCEPTION_MESSAGE_PREFIX +
                        " 로또 숫자는 " + Constants.COUNT_LOTTO_NUMBERS +
                        "개로 이루어져야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 로또 숫자 범위 밖 입력")
    void exceptionMessageTestOutRangeInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new BasicWinLottoNumbers("10000,1,2,3,4,5"));
        assertEquals(ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE.toString(),
                exception.getMessage());
    }

}
