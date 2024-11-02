package lotto.domain;

import lotto.domain.lottoForm.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("로또의 숫자가 6개 미만이면 예외가 발생한다.")
    @Test
    void lottoSizeTest() {
        // given
        List<Integer> numbers = List.of(12, 5, 7, 8, 1);

        // when & then
        assertThatCode(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_ERROR.getMessage());

    }

    @DisplayName("로또에 저장되는 6개의 숫자가 중복되면 예외가 발생한다")
    @Test
    void duplicateTest() {
        // given
        List<Integer> numbers = List.of(12, 12, 12, 4, 6, 8);

        // when & then
        assertThatCode(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("로또에 저장되는 6개의 숫자는 오름차순으로 저장된다.")
    @Test
    void lottoSortTest() {
        // given
        List<Integer> numbers = List.of(31, 12, 1, 7, 45, 26);

        // when
        Lotto lotto = new Lotto(numbers);
        List<Integer> lottoNumbers = lotto.getNumbers();
        System.out.println(lottoNumbers);

        // then
        for (int i = 0; i < LOTTO_SIZE - 1; i++) {
            assertThat(lottoNumbers.get(i)).isLessThan(lottoNumbers.get(i + 1));
        }
    }

}
