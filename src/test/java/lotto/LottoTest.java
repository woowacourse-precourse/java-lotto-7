package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Application.validateNumber;
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
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_값이_입력되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> validateNumber("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> validateNumber(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_숫자가_아닌_경우에는_예외가_발생한다() {
        assertThatThrownBy(() -> validateNumber("ㅁ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateNumber("12ㅁ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> validateNumber("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> validateNumber("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨번호와_중복되는경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).bonusNumber(List.of(1, 2, 3, 4, 5, 6), 1)).isInstanceOf(IllegalArgumentException.class);
    }

}
