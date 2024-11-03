package lotto.domain.number;

import static lotto.LottoValue.MAX_NUMBER;
import static lotto.LottoValue.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.domain.LottoErrorTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호를 테스트한다.")
class BonusNumberTest {

    @DisplayName("성공 케이스를 테스트한다.")
    @Nested
    class HappyCase {

        @DisplayName("보너스 번호가 1~45 면 성공한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 25, 45})
        void successGenerateBonusNumberTest(int bonusNumber) {
            assertDoesNotThrow(() -> new BonusNumber(bonusNumber));
        }
    }

    @DisplayName("실패 케이스를 테스트한다.")
    @Nested
    class EdgeCase {

        @DisplayName("보너스 번호가 1~45 가 아니면 실패한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 46})
        void failGenerateBonusNumberTest(int bonusNumber) {
            assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorTemplate.NUMBER_OUT_OF_RANGE.format(MIN_NUMBER, MAX_NUMBER));
        }
    }
}