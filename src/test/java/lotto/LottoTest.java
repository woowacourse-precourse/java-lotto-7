package lotto;

import static lotto.constants.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessage(INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호_범위_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 47, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 로또_번호_범위_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 45, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 로또_번호_변경시도하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 45, 3, 4, 5, 7));
            lotto.getNumbers().add(2);
        }).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    void 로또_출력형식_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        // when
        String result = lotto.toString();
        // then
        String expectedOutput = "[8, 21, 23, 41, 42, 43]";
        assertEquals(expectedOutput, result);
    }

}
