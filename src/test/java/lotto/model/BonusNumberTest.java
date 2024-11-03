package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.winningNumber.BonusNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스번호_1이상_45이하가_아니면_예외(int testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new BonusNumber(testNumber))
                .withMessage("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
    }
}
