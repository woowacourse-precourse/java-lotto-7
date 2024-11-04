package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.Validator;
import org.junit.jupiter.api.Test;

public class LottoConverterTest {

    @Test
    void 로또_번호는_6개이다() {
        assertThatThrownBy(() -> Validator.isRightSize(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_중복되면_안된다() {
        assertThatThrownBy(() -> Validator.isDuplicated(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_1과_45_사이이다() {
        assertThatThrownBy(() -> Validator.isRightRange(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
