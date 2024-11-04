package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 정상_생성_테스트() {
        int validBonusNumber = 10;

        BonusNumber bonusNumber = new BonusNumber(validBonusNumber);

        assertNotNull(bonusNumber);
        assertEquals(validBonusNumber, bonusNumber.bonusNumber());
    }

    @Test
    void 범위_검증_하한_테스트() {
        int invalidBonusNumber = 0;

        assertThatThrownBy(() -> new BonusNumber(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_RANGE_NOT_MATCH.getMessage());
    }

    @Test
    void 범위_검증_상한_테스트() {
        int invalidBonusNumber = 46;

        assertThatThrownBy(() -> new BonusNumber(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_RANGE_NOT_MATCH.getMessage());
    }
}