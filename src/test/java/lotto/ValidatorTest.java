package lotto;

import lotto.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    Validator validator = new Validator();

    @ParameterizedTest
    @DisplayName("로또 번호를 올바른 형식으로 입력할 수 있다")
    @ValueSource(strings = {"1,10,20,30,40,45", "1, 2, 3, 4, 5, 6"})
    void 로또_번호_정상_테스트(String input) {
        assertThatNoException().isThrownBy(() -> validator.checkLottoNumbers(input));
    }

    @ParameterizedTest
    @DisplayName("로또 번호의 형식이 잘못되면 예외이다")
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,6,7", "1,2,3,4,5"})
    void 로또_번호_예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkLottoNumbers(input));
    }

}
