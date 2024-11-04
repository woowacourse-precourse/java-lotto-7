package lotto.domain;

import lotto.exception.InvalidLottoNumberRangeException;
import lotto.exception.InvalidLottoNumbersDuplicateException;
import lotto.exception.InvalidLottoNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidLottoNumbersSizeException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(InvalidLottoNumbersDuplicateException.class);
    }

    @DisplayName("로또 번호 정렬을 테스트한다.")
    @Test
    void 로또_번호_정렬을_테스트한다() {
        // given
        List<Integer> numbers = List.of(6, 2, 5, 4, 1, 3);
        List<Integer> expectResultNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.toString()).isEqualTo(expectResultNumbers.toString());
    }

    @DisplayName("로또 번호 범위가 1이상 45이하가 아니라면 예외가 발생한다.")
    @Test
    void 로또_번호_범위가_1이상_45이하가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(InvalidLottoNumberRangeException.class);
    }
}
