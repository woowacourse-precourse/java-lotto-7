package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.winning.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @DisplayName("보너스 넘버 생성 실패: 문자 입력.")
    @Test
    void toIntTest() {
        String rawBonusNumber = "aaa";

        assertThatThrownBy(() -> new Bonus(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 넘버를 숫자로 입력해주세요.");
    }

    @DisplayName("보너스 넘버 생성 실패: 1~45 사이의 숫자가 아님.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateRangeTest(int invalidBonusNumber) {
        assertThatThrownBy(() -> new Bonus(String.valueOf(invalidBonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }


}
