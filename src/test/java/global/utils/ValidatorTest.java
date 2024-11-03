package global.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.LottoStatic.LOTTO_END_NUMBER;
import static lotto.constant.LottoStatic.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"1.123", "1.0", "1.000"})
    @DisplayName("구매 금액의 유효성 검사시, 소수를 입력하면 예외가 발생한다")
    void t001(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("소수")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "0"})
    @DisplayName("구매 금액의 유효성 검사시, 0이하의 값을 입력하면 예외가 발생한다")
    void t002(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("0 이하")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", ""})
    @DisplayName("구매 금액의 유효성 검사시, 공백을 입력하면 예외가 발생한다")
    void t003(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("공백")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "zero"})
    @DisplayName("구매 금액의 유효성 검사시, 숫자가 아닌 값을 입력하면 예외가 발생한다")
    void t004(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("숫자")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "zero"})
    @DisplayName("구매 금액의 유효성 검사시, 숫자가 아닌 값을 입력하면 예외가 발생한다")
    void t005(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("숫자")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1", "10001"})
    @DisplayName("구매 금액의 유효성 검사시, 1000원 단위가 아닌 값을 입력하면 예외가 발생한다")
    void t006(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("1000")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1000", "+10000", "+200000"})
    @DisplayName("구매 금액의 유효성 검사시, '+'가 붙은 값을 입력하면 예외가 발생한다")
    void t007(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("+")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000 ", "10000 ", " 200000"})
    @DisplayName("구매 금액의 유효성 검사시, 앞 뒤로 공백이 포함된 숫자를 입력하면 예외가 발생한다")
    void t008(String purchaseAmount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_PREFIX)
                        .hasMessageContaining("공백")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"01000", "010000", "0500000"})
    @DisplayName("구매 금액의 유효성 검사시, 앞에 0이 붙은 값은 입력될 수 없다.")
    void t009(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7", "1,2,3,4,5"})
    @DisplayName("입력한 당첨 번호의 갯수가 6개여야 한다")
    void t010(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("6개");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", ",2,3,4,5,6", "1,2,3,4,5, 6"})
    @DisplayName("입력한 당첨 번호에 공백이나 무입력이 포함될 수 없다")
    void t011(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("공백");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1,2,3,4,5,6", "1,2,3,4,5,6.0", "1,2,3,4.12,5,6"})
    @DisplayName("입력한 당첨 번호에 소수가 포함될 수 없다")
    void t012(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("소수");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "-1,2,3,4,5,6", "1,2,3,4,5,-60000"})
    @DisplayName("입력한 당첨 번호가 0보다 작거나 같을 수 없다")
    void t013(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,+6", "+1,2,3,4,5,+6"})
    @DisplayName("입력한 당첨 번호의 숫자에 '+' 기호가 있을 수 없다")
    void t014(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("+");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "one,2,3,4,5,6"})
    @DisplayName("입력한 당첨 번호에 숫자 이외의 것이 입력될 수 없다")
    void t015(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("숫자");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,1,1,1"})
    @DisplayName("입력한 당첨 번호는 서로 중복되지 않아야 한다")
    void t016(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("중복");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,400,500,600"})
    @DisplayName("입력한 당첨 번호는 1 이상 45 이하여야 한다.")
    void t017(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(String.valueOf(LOTTO_START_NUMBER))
                .hasMessageContaining(String.valueOf(LOTTO_END_NUMBER));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,06", "01,2,3,4,5,6"})
    @DisplayName("입력한 당첨 번호의 앞에 0이 붙을수 없다")
    void t018(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("0");
    }
}