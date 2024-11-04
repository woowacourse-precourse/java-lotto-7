package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    @ParameterizedTest
    @CsvSource({
            "-1000, '[ERROR] 구입금액은 음수가 될수 없습니다.'",
            "그냥문자열, '[ERROR] 숫자 입력 형식이 잘못되었습니다.'",
            "1234, '[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.'",
            "1000.1, '[ERROR] 숫자 입력 형식이 잘못되었습니다.'"
    })
    @DisplayName("유효하지 않은 구입금액이 입력되면 예외가 발생한다.")
    void validateInvalidPurchaseAmountTest(String input, String expectedMessage) {
        // given
        LottoGame lottoGame = new LottoGame();
        // when, then
        assertThatThrownBy(() -> lottoGame.validatePurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

}
