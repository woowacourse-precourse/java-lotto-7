package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeServiceTest {

    @Test
    @DisplayName("calculateMatchCount가 올바르게 동작하는지 확인")
    void testCalculatoeMatahCount(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));

        //when
        int result = LottoPrizeService.calculateMatchCount(winnerLotto, lotto);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("checkEachLottoPrize 1등")
    void testCheckEachLottoPrizeFirstPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.FIRST);
    }

    @Test
    @DisplayName("checkEachLottoPrize 2등")
    void testCheckEachLottoPrizeSecondPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("checkEachLottoPrize 3등")
    void testCheckEachLottoPrizeThirdPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,10));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.THIRD);
    }

    @Test
    @DisplayName("checkEachLottoPrize 4등")
    void testCheckEachLottoPrizeFourthPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,9,10));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.FOURTH);
    }

    @Test
    @DisplayName("checkEachLottoPrize 5등")
    void testCheckEachLottoPrizeFifthPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,8,9,10));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.FIFTH);
    }

    @Test
    @DisplayName("checkEachLottoPrize 5등")
    void testCheckEachLottoPrizeNoPrize(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,7,8,9,10));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoPrize prize = LottoPrizeService.checkEachLottoPrize(winnerLotto, bonusNumber, lotto);

        //then
        assertThat(prize).isSameAs(LottoPrize.NO_PRIZE);
    }


}