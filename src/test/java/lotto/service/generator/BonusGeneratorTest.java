package lotto.service.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusGeneratorTest {

    private Lotto winning;

    @BeforeEach
    void before_each() {
        winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 정수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "2;", "3!33", "k123"})
    void 보너스_번호가_정수가_아닐_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> BonusGenerator.create(winning, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> BonusGenerator.create(winning, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 올바르게 입력되었을 경우 결과를 반환한다.")
    @Test
    void 보너스_번호가_올바르게_입력되었을_경우_결과를_반환한다() {
        String bonus = "7";
        Integer correctBonus = 7;

        BonusGenerator bonusGenerator = BonusGenerator.create(winning, bonus);

        assertThat(bonusGenerator.getBonus().getNumber()).isEqualTo(correctBonus);
    }
}