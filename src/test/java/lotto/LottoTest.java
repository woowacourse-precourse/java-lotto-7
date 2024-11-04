package lotto;

import lotto.common.exception.LottoException;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.common.constant.LottoErrorCode.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void createLottoWithInvalidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void createLottoWithDuplicateNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessage(NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 범위를 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoWithInvalidRange(int invalidNumber) {
        assertThatThrownBy(() ->
                new Lotto(List.of(invalidNumber, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호를 정상적으로 생성한다")
    @Test
    void createLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers())
                .containsExactlyElementsOf(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates();
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 정확히 계산한다")
    @Test
    void countMatchingNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.matchCount(winningLotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 여부를 정확히 판단한다")
    @Test
    void checkBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matchBonus(1)).isTrue();
        assertThat(lotto.matchBonus(7)).isFalse();
    }

    @DisplayName("null이 입력되면 예외가 발생한다")
    @Test
    void createLottoWithNull() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_NUMBER_COUNT.getMessage());
    }
}