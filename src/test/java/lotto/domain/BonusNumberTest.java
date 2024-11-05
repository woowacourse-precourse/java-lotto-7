package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validation.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("번호를 입력하지 않았다면 예외가 발생한다.")
    void 번호를_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "a")
    @DisplayName("숫자를 입력하지 않았다면 예외가 발생한다.")
    void 숫자를_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "400")
    @DisplayName("번호가 1-45 범위가 아니라면 예외가 발생한다.")
    void 번호가_1_45_범위가_아니라면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 이미 있는 번호라면 예외가 발생한다.")
    void 당첨_번호에_이미_있는_번호라면_예외가_발생한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateDuplicate(1, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
