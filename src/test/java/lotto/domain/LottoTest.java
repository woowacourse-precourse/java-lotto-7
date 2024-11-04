package lotto.domain;

import lotto.domain.vo.Number;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        // given // when // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호가_올바를_때_정상적으로_생성된다() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers())
                .extracting(Number::lottoNumber)
                .containsExactlyInAnyOrderElementsOf(validNumbers);
    }

}
