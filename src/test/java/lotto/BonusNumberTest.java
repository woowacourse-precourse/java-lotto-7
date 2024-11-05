package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void throwWhenBonusNumberIsDuplicate() {
        assertThatThrownBy(() -> new BonusNumber(6, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void throwWhenBonusNumberIsNotRange(int input) {
        assertThatThrownBy(() -> new BonusNumber(input, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
