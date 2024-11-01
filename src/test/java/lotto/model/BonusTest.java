package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @ParameterizedTest(name = "보너스 숫자 = {0} 경우")
    @ValueSource(ints = {0,46})
    @DisplayName("보너스 숫자 범위 밖(1미만 45초과) 테스트")
    void 보너스_숫자_범위(int bonus) {
        //when,then
        assertThatThrownBy(() -> new Bonus(bonus)).isInstanceOf(IllegalArgumentException.class);
    }

}