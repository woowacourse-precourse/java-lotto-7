package lotto.domain;

import lotto.domain.number.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;
import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @DisplayName("로또 번호의 범위에 해당하면 성공적으로 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45", "12", "42", "19"})
    void lottoNumberSuccessTest(int rawLottoNumber) {
        // when
        LottoNumber lottoNumber = new LottoNumber(rawLottoNumber);
        int result = lottoNumber.getNumber();

        // then
        assertThat(result).isEqualTo(rawLottoNumber);
    }

    @DisplayName("로또 번호가 0 이하이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-3772398"})
    void negativeLottoNumberExceptionTest(int negativeLottoNumber) {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(negativeLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SCOPE_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 46 이상이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"643", "46", "822", "2434203"})
    void OverScopeLottoNumberExceptionTest(int invalidLottoNumber) {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SCOPE_ERROR.getMessage());
    }
}
