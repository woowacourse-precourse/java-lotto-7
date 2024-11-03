package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    List<Integer> numbers;
    Integer bonusNumber;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        lotto = new Lotto(List.of(1, 2, 3, 10, 20, 40));
    }

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
    @DisplayName("발행한 로또 번호 조회 성공")
    void getNumbers() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(expected);
        List<Integer> actual = lotto.getNumbers();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("맞춘 개수 조회 성공")
    void checkMatchCount() {
        Long expected = 3L;

        Long actual = lotto.checkMatchCount(numbers);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 12, 13, 14})
    @DisplayName("보너스 번호 당첨 여부 확인 - 없는 경우")
    void checkBonusNumberIsFalse(Integer bonusNumber) {
        boolean actual = lotto.checkBonusNumber(bonusNumber);

        assertThat(actual).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10})
    @DisplayName("보너스 번호 당첨 여부 확인 - 있는 경우")
    void checkBonusNumberIsTrue(Integer bonusNumber) {
        boolean actual = lotto.checkBonusNumber(bonusNumber);

        assertThat(actual).isEqualTo(true);
    }
}
