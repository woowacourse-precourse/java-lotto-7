package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {
    private List<Integer> winLotto;
    private int bonusLotto;
    private List<Lotto> issuedLottos;
    private LottoChecker lottoChecker;


    @BeforeEach
    public void setUp(){
        winLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusLotto = 7;
        issuedLottos = new ArrayList<>();
        issuedLottos.add(new Lotto(Arrays.asList(2, 3, 4, 12, 13, 14))); //5등
        lottoChecker = new LottoChecker();
    }

    @Test
    public void checkLotto_테스트(){
        lottoChecker.checkLotto(winLotto, issuedLottos, bonusLotto);
        Map<LottoRank, Integer> rankCount = lottoChecker.getRankCount();
        assertEquals(1,rankCount.get(LottoRank.FIFTH));
        assertEquals(0,rankCount.get(LottoRank.FIRST));
    }

    @Test
    public void 수익률_테스트(){
        lottoChecker.checkLotto(winLotto, issuedLottos, bonusLotto);
        double profit = lottoChecker.calculateProfit(8000);
        assertEquals(62.5,profit);


    }

}