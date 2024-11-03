package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    @DisplayName("유효한 구입금액을 입력 받으면 그 만큼의 로또가 발행된다.")
    @Test
    void lottoGameTest() {
        // given
        InputView inputView = new InputView() {
            @Override
            public String getInput(InputType inputType) {
                return "5000"; // 테스트용 하드코딩된 입력
            }
        };
        LottoGame lottoGame = new LottoGame();
        // when
        lottoGame.purchaseLottos(inputView);
        // then
        assertThat(lottoGame.getLottos().size()).isEqualTo(5); // 5000/1000 = 5장 발행
    }

    @ParameterizedTest
    @CsvSource({
            "-1000, '[ERROR] 구입금액은 음수가 될수 없습니다.'",
            "그냥문자열, '[ERROR] 구입금액 입력이 숫자가 아닙니다.'",
            "1234, '[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.'",
            "1000.1, '[ERROR] 구입금액 입력이 숫자가 아닙니다.'"
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
