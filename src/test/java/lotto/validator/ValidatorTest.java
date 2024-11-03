package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 로또_금액이_1000원_단위가_아닌_경우_예외_테스트() {
        // given
        int invalidAmount = 1500;

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoAmountIsPositiveAndDivisibleByThousand(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
