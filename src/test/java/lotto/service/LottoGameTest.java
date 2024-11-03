package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {


    private LottoGame lottoGame;
    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(5000); // 구입 금액 5000원 -> 로또 5개 생성
    }

    @Test
    void 로또_구매_금액에_따른_개수_생성_테스트(){

        //when
        List<Lotto> userLottoList = lottoGame.generateUserLotto();

        //then
        assertEquals(5, userLottoList.size());
    }

    @Test
    void 로또_당첨_결과_생성_테스트() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 로또 번호를 고정된 값으로 설정하여 당첨 여부 테스트
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoGame.getUserLottoList().add(lotto);

        // when
        lottoGame.generateWinningResults(winningNumbers, bonusNumber);

        // then
        Map<WinningResult, Integer> winningResultCount = lottoGame.getWinningResultCount();
        assertEquals(1, winningResultCount.get(WinningResult.THREE_MATCH));
        assertEquals(0, winningResultCount.get(WinningResult.SIX_MATCH));
    }



}
