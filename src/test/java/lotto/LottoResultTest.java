package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class LottoResultTest {

    @Test
    void 로또_결과_조정() {

        //given
        WinningLottoNumberSelector winningLottoNumberSelector = new WinningLottoNumberSelector(
                new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber("7")),
                List.of(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,8")));
        LottoResult lottoResult = new LottoResult();
        //when
        LottoResult resultAfterAdjust = lottoResult.adjustLottoResult(winningLottoNumberSelector);
        //then
        assertThat(resultAfterAdjust.winningStatistics.get(CorrectStatus.SIX_CORRECT)).isEqualTo(1);
        assertThat(resultAfterAdjust.winningStatistics.get(CorrectStatus.FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER)).isEqualTo(1);
        assertThat(resultAfterAdjust.winningStatistics.get(CorrectStatus.FIVE_CORRECT_WITH_SPECIAL_NUMBER)).isEqualTo(0);
        assertThat(resultAfterAdjust.winningStatistics.get(CorrectStatus.FOUR_CORRECT)).isEqualTo(0);
    }

    @Test
    void 로또_수익_계산() {
        //given
        WinningLottoNumberSelector winningLottoNumberSelector = new WinningLottoNumberSelector(
                new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber("7")),
                List.of(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,8")));
        LottoResult lottoResult = new LottoResult();
        LottoResult resultAfterAdjust = lottoResult.adjustLottoResult(winningLottoNumberSelector);

        //when
        long profit = resultAfterAdjust.profit();

        //then
        Assertions.assertThat(profit).isEqualTo(CorrectStatus.SIX_CORRECT.getReward()+CorrectStatus.FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER.getReward());

    }

    @Test
    void 로또_수익_INT_넘을때(){

        //given
        WinningLottoNumberSelector winningLottoNumberSelector = new WinningLottoNumberSelector(
                new WinningNumber(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),new SpecialNumber("7")),
                List.of(Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,6"),
                        Lotto.createWinningRegularLotto("1,2,3,4,5,6")));
        LottoResult lottoResult = new LottoResult();
        LottoResult resultAfterAdjust = lottoResult.adjustLottoResult(winningLottoNumberSelector);
        //when
        long profit = resultAfterAdjust.profit();
        //then
        Assertions.assertThat(profit).isEqualTo((long)CorrectStatus.SIX_CORRECT.getReward()*6);
    }
}