package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("로또 번호의 숫자가 6개가 아니면 예외가 발생한다.")
    @Test
    void numberCount() {
        //given
        List<Integer> case1 = List.of(1, 2, 3, 4, 5);

        //when
        final Throwable thrown = catchThrowable(() -> {
            new Lotto(case1);
        });

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("로또 번호의 숫자 범위가 1부터 45가 아니면 예외가 발생한다.")
    @Test
    void numberScope() {
        //given
        List<Integer> case1 = List.of(1, 2, 3, 4, 5, 0);
        List<Integer> case2 = List.of(1, 2, 3, 4, 5, 46);

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            new Lotto(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            new Lotto(case2);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
        assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("45 이하");
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다")
    @Test
    void numbersSort() {
        //given
        List<Integer> case1 = List.of(2, 4, 3, 6, 1, 5);
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto test = new Lotto(case1);

        //then
        assertThat(test.getNumbers())
                .isEqualTo(result);
    }
}
