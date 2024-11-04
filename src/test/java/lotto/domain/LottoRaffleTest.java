package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.controller.Validator;
import lotto.utils.FixedNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRaffleTest {
    private LotteryMachine lotteryMachine;
    private int BONUS_NUMBER;
    Validator validator = new Validator();

    @BeforeEach
    void createWinningLotto() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(winningNumber));
    }

    @Test
    void 당첨번호가_로또번호범위에서벗어나면_예외가발생한다() {

        BONUS_NUMBER = 7;
        List<Integer> notInRangeNumber = List.of(1, 2, 3, 4, 5, 47);
        assertThatThrownBy(() ->
                validator.validateWinningNumber(new Lotto(notInRangeNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_로또번호범위에서벗어나면_예외가발생한다() {

        BONUS_NUMBER = 47;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() ->
                validator.validateBonusNumber(winningNumber, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

}