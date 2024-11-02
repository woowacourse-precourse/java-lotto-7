package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("보너스 번호는 1 부터 45 사이의 값만 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidRangeBonusNumber(int bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThatThrownBy(() -> BonusNumberValidator.validate(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1 부터 45 사이의 값을 가질 수 있습니다.");
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void duplicateBonusNumber(int bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThatThrownBy(() -> BonusNumberValidator.validate(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}