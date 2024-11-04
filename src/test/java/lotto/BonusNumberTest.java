package lotto;

import lotto.domain.BonusNumberValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> bonusNumberValidator.validate("1", numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호의_범위가_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> bonusNumberValidator.validate("55", numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 비어있는 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_비어있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> bonusNumberValidator.validate(" ", numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_정수가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> bonusNumberValidator.validate("a", numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
