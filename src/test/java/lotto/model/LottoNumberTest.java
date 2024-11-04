package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 로또_번호가_1과_45_사이_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> new LottoNumber(90))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
