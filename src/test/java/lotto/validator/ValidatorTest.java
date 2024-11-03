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
    void 당첨_번호가_1에서_45_사이가_아닌_경우_예외_테스트(){
        //given
        List<Integer> lottoWinningNumbers = Arrays.asList(8, 21, 23, 41, 42, 46);

        //when & then
        assertThatThrownBy(() -> Validator.validateLottoNumberInRangeOneToFortyFive(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 당첨_번호가_6개가_아닌_경우_예외_테스트(){
        //given
        List<Integer> lottoWinningNumbers = Arrays.asList(8, 21, 23, 41, 42);

        //when & then
        assertThatThrownBy(() -> Validator.validateLottoWinningNumbersCount(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_있는_경우_예외_테스트(){
        //given
        List<Integer> lottoWinningNumbers = Arrays.asList(8, 21, 23, 41, 41, 44);

        //when & then
        assertThatThrownBy(() -> Validator.validateDuplicateWinningNumbers(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_구분자가_쉼표가_아닌_경우_예외_테스트(){
        //given
        String lottoWinningNumbers = "41,42,43,44,45.1";

        //when & then
        assertThatThrownBy(() -> Validator.validateWinningNumberSeparatorAndNotNumber(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_숫자가_아닌_경우_예외_테스트(){
        //given
        String lottoWinningNumbers = "41,42,43,44,이,1";

        //when & then
        assertThatThrownBy(() -> Validator.validateWinningNumberSeparatorAndNotNumber(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_숫자를_여러개_입력한_경우_예외_테스트(){
        //given
        String lottoWinningNumbers = "41,42";

        //when & then
        assertThatThrownBy(() -> Validator.validateSingleBonusNumber(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
