package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber, new WinnerResult());
    }

    @Test
    @DisplayName("로또와 당첨번호와 비교하여 몇 개가 일치하는지 구할 수 있다.")
    void 로또와_당첨번호와_비교하여_몇_개가_일치하는지_구할_수_있다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 8));

        //when
        winningLotto.findEachWinningLottery(lotto, winningLotto.getNumbers());

        //then
        Winners winners = Winners.FIVE_MATCHED;
        assertEquals(1, winningLotto.getWinnerResult().getAmount(winners));
    }

}