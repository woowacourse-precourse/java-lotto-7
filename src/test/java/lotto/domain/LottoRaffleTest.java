package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.utils.FixedNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRaffleTest {
    private LotteryMachine lotteryMachine;
    private int BONUS_NUMBER;

    @BeforeEach
    void createWinningLotto() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(winningNumber));
    }

    @Test
    void 당첨번호가_로또번호범위에서벗어나면_예외가발생한다() {

        BONUS_NUMBER = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 47));

        assertThatThrownBy(() ->
                new LottoRaffle(lotto, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_로또번호범위에서벗어나면_예외가발생한다() {

        BONUS_NUMBER = 47;

        assertThatThrownBy(() ->
                new LottoRaffle(lotteryMachine.createLottoTicket(), BONUS_NUMBER));
    }

    @Test
    void 보너스번호가_당첨번호와중복되면_예외가발생한다() {

        BONUS_NUMBER = 1;

        assertThatThrownBy(() ->
                new LottoRaffle(lotteryMachine.createLottoTicket(), BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }
}