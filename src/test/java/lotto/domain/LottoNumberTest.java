package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    public void 같은_값을_같는_로또숫자는_같다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    public void 로또넘버를_생성한다() {
        assertThat(new LottoNumber("1")).isEqualTo(new LottoNumber(1));
    }

    @Test
    public void 숫자가_값을_입력하면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber("a"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또숫자는_유효하지_않는_숫자가_입력시예외가_발생한다(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
