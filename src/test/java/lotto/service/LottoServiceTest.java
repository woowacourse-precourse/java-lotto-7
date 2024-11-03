package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    @DisplayName("당첨 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void lottoNumbersNotNumber() {
        assertThatThrownBy(() -> LottoService.splitLottoNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 정수 범위를 벗어나는 값이 있으면 예외가 발생한다.")
    @Test
    void lottoNumbersOutOfRange() {
        assertThatThrownBy(() -> LottoService.splitLottoNumbers("1,2,3,4,5,2147483648"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
