package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 올바르게 찾아야한다.")
    @Test
    void testCountMatchingNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 11, 12, 13);

        int matchCount = lotto.countMatchNumbers(winningNumbers);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 일치하는 번호가 있는지 확인할 수 있어야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "11:false"}, delimiter = ':')
    void testContainsBonusNumber(int bonusNumber, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.isMatchBonusNumber(bonusNumber);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 번호를 올바른 형식에 맞게 출력해야한다.")
    @Test
    void testPrintLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String printLottoNumbers = "[1, 2, 3, 4, 5, 6]";

        assertThat(lotto.toString()).isEqualTo(printLottoNumbers);
    }
}
