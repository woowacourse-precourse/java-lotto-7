package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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
    @DisplayName("중복 테스트")
    void duplicatedBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("1");

        // when & then
        assertThatThrownBy(() -> bonusNumber.validateDuplicated(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 범위 입력 테스트")
    void validBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber("30");

        assertNotNull(bonusNumber);
    }
}
