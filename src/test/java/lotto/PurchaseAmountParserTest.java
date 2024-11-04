package lotto;

import lotto.parser.PurchaseAmountParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountParserTest {
    @Test
    @DisplayName("정상적인 경우 파싱")
    void 기능_테스트1() {
        // given
        String input = "8000";

        // when
        int result = PurchaseAmountParser.parse(input);

        // then
        assertThat(result).isEqualTo(8000);
    }


    @Test
    @DisplayName("null 입력시 예외 발생")
    void 예외_테스트1() {
        // given
        String input = null;

        assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("빈 입력 시 예외 발생")
    void 예외_테스트2() {
        // given
        String input = "";

        assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("공백 입력 시 예외 발생")
    void 예외_테스트3() {
        // given
        String input = "        ";

        assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("아라비아 숫자 이외의 값 입력 시 예외 발생")
    void 예외_테스트4() {
        // given
        String input = "8 0만원plus1000";

        assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다. (예: 1000)");
    }

    @Test
    @DisplayName("1000단위가 아닌 숫자 입력 시 예외 발생")
    void 예외_테스트5() {
        // given
        String input = "6500";

        assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000단위의 양수만 입력 가능합니다.");
    }
}
