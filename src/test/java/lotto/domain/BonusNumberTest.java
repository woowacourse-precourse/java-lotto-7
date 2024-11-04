package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    private static final String ERROR_PREFIX = "[ERROR]";

    @DisplayName("보너스 번호가 1-45 범위면 정상 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 42, 43, 44, 45})
    void 보너스_번호가_1_45_범위면_정상_생성된다(int inboundNumber) {
        BonusNumber bonusNumber = new BonusNumber(inboundNumber);

        assertThat(bonusNumber.getNumber()).isEqualTo(inboundNumber);
    }

    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 100})
    void 보너스_번호가_1_45_범위를_벗어나면_예외가_발생한다(int outboundNumber) {
        assertThatThrownBy(() -> new BonusNumber(outboundNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_PREFIX);
    }
}
