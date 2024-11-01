package lotto;

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

    @DisplayName("로또는_주어진_구분자로_자신의_번호를_오름차순으로_읽어_문자열로_반환할_수_있다")
    @Test
    public void readNumberAscending() {
        //given
        Lotto lotto = new Lotto(List.of(1, 6, 4, 3, 2, 5));
        String delimiter = ", ";

        //when
        String result = lotto.readNumberAscending(delimiter);

        //then
        assertThat(result).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}
