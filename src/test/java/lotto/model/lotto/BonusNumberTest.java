package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호 예외 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {"&", "0", "46"})
    void invalidBonusNumber(final String input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    

    @Test
    @DisplayName("정상 범위 입력 테스트")
    void validBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber("30");

        assertNotNull(bonusNumber);
    }
}
