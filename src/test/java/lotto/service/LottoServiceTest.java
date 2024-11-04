package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.type.LottoRank;
import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.response.LottoCalculateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    @DisplayName("6개 번호가 일치하는 경우 당첨 결과를 제대로 계산한다.")
    @Test
    void calculateRankSiz() {
        //given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Money money = new Money(3000);

        //when
        List<Lotto> lottoList = List.of(winningLotto);
        lottoService.createLottoList(new LottoMoneyRequest(3000));
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 7, lottoList, money);

        //then
        assertEquals(1, response.prizeCounts().get(LottoRank.SIX));
    }

    @DisplayName("5개 번호가 일치하는 경우 bonus 번호까지 일치하여 당첨 결과를 제대로 계산한다.")
    @Test
    void calculateRankFiveWithBonus() {
        // given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Money money = new Money(3000);

        // when
        List<Lotto> lottoList = List.of(winningLotto);
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 6, lottoList, money);

        // then
        assertEquals(1, response.prizeCounts().getOrDefault(LottoRank.FIVE_WITH_BONUS, 0));
    }

    @DisplayName("5개 번호가 일치하는 경우 당첨 결과를 제대로 계산한다.")
    @Test
    void calculateRankFive() {
        // given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Money money = new Money(3000);

        // when
        List<Lotto> lottoList = List.of(winningLotto);
        lottoService.createLottoList(new LottoMoneyRequest(3000));
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 7, lottoList, money);

        // then
        assertEquals(1, response.prizeCounts().getOrDefault(LottoRank.FIVE, 0));
    }

    @DisplayName("4개 번호가 일치하는 경우 당첨 결과를 제대로 계산한다.")
    @Test
    void calculateRankFour() {
        // given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Money money = new Money(3000);

        // when
        List<Lotto> lottoList = List.of(winningLotto);
        lottoService.createLottoList(new LottoMoneyRequest(3000));
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 7, lottoList, money);

        // then
        assertEquals(1, response.prizeCounts().getOrDefault(LottoRank.FOUR, 0));
    }

    @DisplayName("3개 번호가 일치하는 경우 당첨 결과를 제대로 계산한다.")
    @Test
    void calculateRankThree() {
        // given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Money money = new Money(3000);

        // when
        List<Lotto> lottoList = List.of(winningLotto);
        lottoService.createLottoList(new LottoMoneyRequest(3000));
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 10, lottoList, money);

        // then
        assertEquals(1, response.prizeCounts().getOrDefault(LottoRank.THREE, 0));
    }

    @DisplayName("당첨 결과가 없을 때도 결과를 정확히 계산한다.")
    @Test
    void calculateRankNone() {
        // given
        LottoService lottoService = new LottoService();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(9, 10, 11, 12, 13, 14));
        Money money = new Money(3000);

        // when
        List<Lotto> lottoList = List.of(winningLotto);
        lottoService.createLottoList(new LottoMoneyRequest(3000));
        LottoCalculateResponse response = lottoService.calculateLotto(userLotto, 15, lottoList, money);

        // then
        assertEquals(1, response.prizeCounts().getOrDefault(LottoRank.NONE, 0));
    }
}