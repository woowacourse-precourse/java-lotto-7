package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusTest {

    @ParameterizedTest
    @CsvSource({"-1", "46", "100", "0"})
    void 번호가_1이상_45이하가_아니라면_예외가_빌생한다(int number) {
        assertThatThrownBy(() -> new Bonus(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1이상 45이하여야 합니다.");
    }
}