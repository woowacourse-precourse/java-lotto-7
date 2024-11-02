package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @Test
    @DisplayName("보너스 번호 - 공백")
    void blankBonusNumber() {
        assertThatThrownBy(() -> Bonus.of("", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 - 숫자가 아닌 문자")
    void notNumericBonusNumber() {
        assertThatThrownBy(() -> Bonus.of("a", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 - 너무 큰 숫자")
    void tooBigBonusNumber() {
        assertThatThrownBy(() -> Bonus.of("100000000000000", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_BIG_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 - 1에서 45사이의 숫자가 아닌 경우")
    void outRangeBonusNumber() {
        assertThatThrownBy(() -> Bonus.of("100", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_RANGE_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 - 당첨 번호와 중복되는 경우")
    void duplicateBonusNumber() {
        assertThatThrownBy(() -> Bonus.of("1", new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }
}