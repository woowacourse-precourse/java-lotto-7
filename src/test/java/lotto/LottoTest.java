package lotto;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    @DisplayName("Lotto 객체의 번호는 오름차순으로 정렬되어야 한다")
    void lottoNumbers_shouldBeSortedAscending() {
        // given
        List<Integer> unsortedNumbers = List.of(6, 3, 1, 5, 4, 2);

        // when
        Lotto lotto = new Lotto(unsortedNumbers);

        // then
        Assertions.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("범위를 벗어난 번호로 생성 시 예외 발생")
    void createLotto_withOutOfRangeNumbers() {
        // given
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE.getErrorMessage());
    }
}
