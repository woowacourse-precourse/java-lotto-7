package lotto;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinnerResult;
import lotto.domain.Winners;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호 3개 일치")
    void 번호_3개_일치(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1,2,3,7,8,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findEachWinningLottery(lotto, winningNumbers);

        //then
        assertEquals(1, winnerResult.getAmount(Winners.THREE_MATCHED));
    }

    @Test
    @DisplayName("번호 4개 일치")
    void 번호_4개_일치(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1,2,3,4,8,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findEachWinningLottery(lotto, winningNumbers);

        //then
        assertEquals(1, winnerResult.getAmount(Winners.FOUR_MATCHED));
    }

    @Test
    @DisplayName("번호 5개 일치")
    void 번호_5개_일치(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findEachWinningLottery(lotto, winningNumbers);

        //then
        assertEquals(1, winnerResult.getAmount(Winners.FIVE_MATCHED));
    }

    @Test
    @DisplayName("번호 5개 일치, 보너스볼 일치")
    void 번호_5개_일치_보너스볼_일치(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findEachWinningLottery(lotto, winningNumbers);

        //then
        assertEquals(1, winnerResult.getAmount(Winners.FIVE_BONUS_MATCHED));
    }

    @Test
    @DisplayName("번호 6개 일치")
    void 번호_6개_일치(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findEachWinningLottery(lotto, winningNumbers);

        //then
        assertEquals(1, winnerResult.getAmount(Winners.SIX_MATCHED));
    }

    @Test
    @DisplayName("번호 3개 일치한 로또 개수가 2개")
    void 번호_3개_일치한_로또개수가_2개(){
        //given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 8, 11, 12));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 8, 12, 13));

        List<Lotto> lottos =  new ArrayList<>();
        lottos.add(firstLotto);
        lottos.add(secondLotto);

        LottoGroup lottoGroup = new LottoGroup(lottos);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        int bonusNumber = 10;

        //when
        WinnerResult winnerResult = new WinnerResult();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber, winnerResult);

        winningLotto.findWinningLottery(lottoGroup, winningLotto);

        //then
        assertEquals(2, winnerResult.getAmount(Winners.THREE_MATCHED));
    }

}
