package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoExceptionTest {
    private static final String ERROR = "[ERROR] ";

    @Test
    @DisplayName("IllegalArgumentException으로 잘 작동하는지")
    void isSuccess() {
        // given
        LottoException lottoException = new LottoException(ErrorMessage.NOT_SIX_NUM);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            throw lottoException;
        });
        // then
        assertEquals(ErrorMessage.NOT_SIX_NUM.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("에러메세지 리턴")
    void getErrorMessage() {
        // given
        LottoException lottoException = new LottoException(ErrorMessage.NOT_SIX_NUM);

        // when
        String message = lottoException.makeErrorMessage();

        // then
        assertEquals(ERROR+ErrorMessage.NOT_SIX_NUM.getMessage(), message);
    }
}