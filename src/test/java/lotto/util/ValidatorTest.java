package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    LottoValidator validator = new LottoValidator();

    @DisplayName("로또 번호를 올바른 형식으로 입력할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1,10,20,30,40,45", "1, 2, 3, 4, 5, 6"})
    void 로또_번호_정상_테스트(String input) {
        assertThatNoException().isThrownBy(() -> validator.checkLottoNumbers(input));
    }

    @DisplayName("로또 번호의 형식이 잘못되면 예외이다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,6,7", "1,2,3,4,5"})
    void 로또_번호_예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkLottoNumbers(input));
    }

    @DisplayName("보너스 번호는 1과 45사이의 값이여야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "20", "30", "40", "45"})
    void 보너스_번호_정상_테스트(String input) {
        assertThatNoException().isThrownBy(() -> validator.checkBonusNumber(input));
    }

    @DisplayName("보너스 번호가 1과 45사이의 값이 아니면 예외이다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void 보너스_번호_예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkBonusNumber(input));
    }

    @DisplayName("구입 금액은 1,000원 단위로 입력할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "8000", "12000", "24000", "127000"})
    void 구입_금액_정상_테스트(String input) {
        assertThatNoException().isThrownBy(() -> validator.checkPurchaseMoney(input));
    }

    @DisplayName("구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외이다")
    @ParameterizedTest
    @ValueSource(strings = {"0000", "000", "200", "500", "1100", "2200"})
    void 구입_금액_예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkPurchaseMoney(input));
    }
}
