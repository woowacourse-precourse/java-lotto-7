package lotto.domain;

import static lotto.config.ErrorMessageConstant.DUPLICATED_BONUS_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.INVALID_RANGE_NUMBER_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineBonusNumberTest {
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        lottoMachine = new LottoMachine();
        lottoMachine.assignWinningNumbers(winningNumber);
    }

    @Test
    void 보너스_번호_입력() {
        int bonusNumber = 7;
        assertDoesNotThrow(() ->
                lottoMachine.assignBonusNumber(bonusNumber)
        );
    }

    @Test
    void 중복된_보너스_번호_입력() {
        int bonusNumber = 6;
        assertThatThrownBy(() -> lottoMachine.assignBonusNumber(bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS_NUMBER_MESSAGE);
    }

    @Test
    void 허용범위_외_숫자_입력() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> lottoMachine.assignBonusNumber(bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_NUMBER_MESSAGE);
    }
}