package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또숫자는_유효하지_않는_숫자가_입력시예외를_발생한다(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
