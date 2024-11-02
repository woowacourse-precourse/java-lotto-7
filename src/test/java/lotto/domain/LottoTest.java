package lotto.domain;

import lotto.domain.lottoForm.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTest {

    @DisplayName("로또는 6개의 숫자로 이루어져야 한다.")
    @Test
    void lottoSizeTest() {
        // given
        List<Integer> numbers = List.of(12, 5, 7, 8, 1, 9, 27);

        // when & then
        assertThatCode(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_ERROR.getMessage());

    }

    @DisplayName("로또에 저장되는 6개의 숫자는 중복되면 안된다.")
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
