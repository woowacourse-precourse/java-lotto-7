package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 34, 44, 45})
    void 보너스_번호_정상_입력() {
        Assertions.assertThat(new BonusBall(10))
                .isInstanceOf(BonusBall.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 390, 100020, 4325234})
    void 보너스_번호_범위_초과_입력(int bonus) {
        // given
        // when, then
        assertThrows(IllegalArgumentException.class, () -> new BonusBall(bonus));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1090, -10, -1})
    void 보너스_번호_범위_미만_입력(int bonus) {
        // given
        // when, then
        assertThrows(IllegalArgumentException.class, () -> new BonusBall(bonus));
    }

}