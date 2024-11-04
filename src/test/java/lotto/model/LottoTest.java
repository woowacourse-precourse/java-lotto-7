package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import lotto.exception.LottoErrorMessage;
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
    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    void lottoNumberRangeErrorTest() {
        //given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        //when && then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 정렬되어 저장된다.")
    void lottoNumberSortTest() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1, 6, 5, 4));
        final List<Integer> expected = numbers.stream().sorted().toList();

        //when
        Lotto lotto = new Lotto(numbers);
        var lottoNumbers = lotto.getNumbers();

        //then
        assertThat(lottoNumbers).
                isEqualTo(expected);
    }
}
