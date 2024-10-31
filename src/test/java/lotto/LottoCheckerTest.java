package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @Test
    public void 테스트(){
        List<Integer> winLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        List<Lotto> issuedLottos = new ArrayList<>();
        issuedLottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))); //2등
        issuedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); //1등
        issuedLottos.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9))); //4등
        issuedLottos.add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))); //당첨x

        LottoChecker lottoChecker = new LottoChecker();
        lottoChecker.checkLotto(winLotto, issuedLottos, bonusLotto);
        assertEquals(lottoChecker.getLottoRanks().get(0),LottoRank.SECOND);
        assertEquals(lottoChecker.getLottoRanks().get(1),LottoRank.FIRST);
        assertEquals(lottoChecker.getLottoRanks().get(2),LottoRank.FOURTH);
        assertEquals(lottoChecker.getLottoRanks().get(3),LottoRank.MISS);



    }

}