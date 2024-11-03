package lotto;

import lotto.exception.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 입력된_당첨번호_문자열_배열의_크기가_6이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE.getMessage());
    }

    @DisplayName("숫자 문자열 배열에 숫자 문자열이 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 숫자_문자열_배열에_숫자_문자열이_범위_내_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 46, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45.getMessage());
    }
}
