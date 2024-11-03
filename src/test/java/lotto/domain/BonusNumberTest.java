package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("BonusNumber 객체 생성 테스트")
    @Test
    void createBonusNumber() {
        BonusNumber bonusNumber = BonusNumber.from("7", WinningNumber.from("1,2,3,4,5,6"));

        Assertions.assertThat(bonusNumber.isEqualTo(7)).isTrue();
    }

    @DisplayName("보너스 번호에 1~45 범위 바깥의 숫자를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-3", "0", "46"})
    void checkBonusNumberInRange(String inputBonusNumber) {
        Assertions.assertThatThrownBy(() -> BonusNumber.from(inputBonusNumber, WinningNumber.from("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1~45 사이의 숫자를 입력해야 합니다.");
    }
}
