package lotto;

import lotto.model.Bonus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 보너스_번호의_범위는_1에서_45사이이다(Integer bonusNumber) {
        // when, then
        Assertions.assertDoesNotThrow(() -> {
            new Bonus(bonusNumber);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49})
    void 보너스_번호의_범위가_1에서_45사이가_아니라면_예외를_반환한다(Integer bonusNumber) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Bonus(bonusNumber);
        });
    }
}
