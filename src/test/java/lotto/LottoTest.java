package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 1~45사이에 없으면 예외가 발생하한다.")
    @Test
    void 로또_번호가_범위내에_없으면_예외가_발생한다() {
        //given
        List<Integer> lotto_number = List.of(0, 1, 45, 46, 5, 6);
        //when
        Throwable thrown = catchException(() -> new Lotto(lotto_number));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_오름차순으로_정렬한다() {
        //given
        List<Integer> lotto_number = List.of(45, 43, 42, 41, 1, 2);
        Lotto lotto = new Lotto(lotto_number);
        //when
        List<Integer> result = lotto.getNumbers();
        //then
        assertThat(result).isEqualTo(List.of(1, 2, 41, 42, 43, 45));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 로또_번호는_null_또는_빈값이_입력될_경우_예외가_발생한다(List<Integer> input) {
        //when
        Throwable thrown = catchException(() -> new Lotto(input));
        //given
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

}
