package lotto.model.win;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.message.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호 객체 테스트")
class BonusNumberTest {

    @DisplayName("보너스 번호가 올바른 경우 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "보너스 번호: {0}")
    @ValueSource(ints = {1, 45})
    void shouldNotThrowException_WhenBonusNumberIsValid(int number) {
        assertDoesNotThrow(() -> new BonusNumber(number));
    }

    @DisplayName("보너스 번호가 로또 숫자 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest(name = "보너스 번호: {0}")
    @ValueSource(ints = {0, 46})
    void shouldThrowException_WhenBonusNumberOutOfRange(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.get());
    }
}
