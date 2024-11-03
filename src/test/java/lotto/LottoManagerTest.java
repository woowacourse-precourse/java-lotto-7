package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    private LottoManager lottoManager;
    private static final List<Lotto> lottoTestSet = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        lottoTestSet.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoTestSet.add(new Lotto(Arrays.asList(1,2,3,4,5,7)));
        lottoTestSet.add(new Lotto(Arrays.asList(1,2,3,4,5,14)));
        lottoTestSet.add(new Lotto(Arrays.asList(1,2,3,4,34,35)));
        lottoTestSet.add(new Lotto(Arrays.asList(1,2,3,12,13,14)));
        lottoTestSet.add(new Lotto(Arrays.asList(33,34,11,12,13,14)));
    }


    @Test
    void 생성자_정상_작동() {
        lottoManager = new LottoManager(4000L);
        assertEquals(4, lottoManager.getLotties().size());// 사이즈 체크
        assertEquals(4000, lottoManager.getMoney());  // runTimes 체크
    }

    @Test
    void 로또_번호_비교_정상_작동() {
        lottoManager = new LottoManager(0L);
        lottoManager.setBonusNumber(7);
        lottoManager.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        for (Lotto testLotto : lottoTestSet) {
            lottoManager.isLottoWin(testLotto);
        }
        for (int i=0; i<lottoManager.getWinLottiesCount().size(); i++){
            assertEquals(1, lottoManager.getWinLottiesCount().get(i));
        }
    }

    @Test
    void 로또_수익률_정상_작동() {
        lottoManager = new LottoManager(0L);
        lottoManager.setBonusNumber(7);
        lottoManager.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        for (Lotto testLotto : lottoTestSet) {
            lottoManager.isLottoWin(testLotto);
        }
        lottoManager.setMoney(lottoTestSet.size() * 1000L);
        assertEquals(Double.valueOf(33859250), lottoManager.calculateEarnRate());
    }

}
