package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("BonusNumber 객체 생성 테스트")
    @Test
    void createBonusNumber() {
        BonusNumber bonusNumber = BonusNumber.from("7", WinningNumber.from("1,2,3,4,5,6"));

        Assertions.assertThat(bonusNumber.isEqualTo(7)).isTrue();
    }
}
