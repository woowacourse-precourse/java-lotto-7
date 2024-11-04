package lotto.model.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 로또 번호를 래핑하여 정상 생성된다.")
    void testBonusNumberWrapLottoNumber() {
        BonusNumber bonusNumber = new BonusNumber("7");
        assertThat(bonusNumber.getBonusNumber().getNumber()).isEqualTo(7);
    }
}