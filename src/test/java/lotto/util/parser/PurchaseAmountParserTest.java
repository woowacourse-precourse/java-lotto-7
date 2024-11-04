package lotto.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountParserTest {

    @DisplayName("구입 금액을 입력할 때 빈 문자열을 입력할 수 없다.")
    @ParameterizedTest
    @EmptySource
    void inputEmptyString(String rawPurchaseAmount) {

        assertThatThrownBy(() -> PurchaseAmountParser.parseRawPurchaseAmount(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액으로 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요.");

    }

    @DisplayName("구입 금액 입력시 숫자가아닌 문자를 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", ":qwe", "a1b1b2"})
    void inputNotIntegerString(String rawPurchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountParser.parseRawPurchaseAmount(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 정수형 범위의 숫자만 입력할 수 있습니다. 다시 시도해 주세요.");
    }

    @DisplayName("숫자로 이루어진 문자열이 들어올 경우 해당 문자열을 정수로 변환해서 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3", "45, 45"})
    void parseRawPurchaseAmount(String rawPurchaseAmount, int expected) {

        int purchaseAmount = PurchaseAmountParser.parseRawPurchaseAmount(rawPurchaseAmount);

        assertThat(purchaseAmount).isEqualTo(expected);
    }
}