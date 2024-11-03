package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BuyPriceTest {

    @DisplayName("구매금액에 글자나 특수문자가 세팅되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"13000원", "42000#", "@3000", "3,000", "((((", "{1234", "a1234"})
    void 구매금액에_글자_혹은_특수문자_입력시_예외_발생(String input) {
        assertThatThrownBy(() -> new BuyPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 숫자만 입력해주세요.");
    }

    @DisplayName("공백이 입력값 중간이나 양 끝에 존재해도 정상적으로 세팅이 되어야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"13 000", "13000 ", " 13000", " 13000 ", " 1 3 0 0 0 "})
    void 공백이_입력값에_있어도_정상_세팅_되어야함(String input) {
        assertDoesNotThrow(() -> new BuyPrice(input));
    }

    @DisplayName("구매금액이 천원 단위가 아니면 예외가 발생된다")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "10001", "9999", "10010"})
    void 금액이_천원_단위가_아니면_예외_발생(String input) {
        assertThatThrownBy(() -> new BuyPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잔돈이 없습니다. 1000원 단위에 맞춰 입력해주세요.");
    }
}
