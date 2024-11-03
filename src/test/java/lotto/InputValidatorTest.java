package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("입력값 검증 테스트")
public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"이천원", "abcd", "1000원", "천원"})
    @DisplayName("로또 구매 금액이 숫자가 아니라면 예외가 발생한다.")
    void 실패_로또구입_숫자아님() {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from("이천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000", "-5000"})
    @DisplayName("구매 금액이 0 이하이면 예외가 발생한다.")
    void 실패_로또구입_0원이하() {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1700", "2900", "999"})
    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생한다")
    void 실패_로또구입_1000원단위_아님() {
        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000000", "99999999999999", "2147483648"})
    @DisplayName("너무 큰 값이 입력되면 예외가 발생한다")
    void 실패_로또구입_숫자형식_범위초과(String input) {
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 너무 큽니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "9000", "100000"})
    @DisplayName("정상적인 구매입력값이 입력되면 정상 처리된다.")
    void 성공_로또구입_알맞은_입력값() {
        // when & then
        assertThatCode(() -> PurchaseAmount.from("3000"))
                .doesNotThrowAnyException();
    }
}
