package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @DisplayName("보너스 숫자가 기존 뽑은 로또 숫자와 중복 될 때")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2","3","4","5","6"})
    void 입력값_중복_시(String specialNumber) {
        assertThatThrownBy(() -> new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber(specialNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_MUST_NOT_DUPLICATE.getMessage());
    }ㄱ

}