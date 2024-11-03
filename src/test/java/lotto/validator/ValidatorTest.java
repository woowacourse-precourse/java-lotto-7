package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void 당첨_번호가_1에서_45_사이가_아닌_꼉우_예외_테스트(){
        //given
        List<Integer> lottoWinningNumbers = Arrays.asList(8, 21, 23, 41, 42, 46);

        //when & then
        assertThatThrownBy(() -> Validator.validateLottoNumberInRangeOneToFortyFive(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
