package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResultManager;
import lotto.model.enums.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    private List<Lotto> userLottoList;
    private Lotto winingLotto;
    private BonusNumber bonusNumber;
    @BeforeEach
    void setUp() {
        userLottoList = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),    // 3개 일치 -> 5등
                new Lotto(List.of(7, 8, 9, 10, 11, 12)), // 0개 일치 -> 탈락
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 5개 일치 -> 3등
                new Lotto(List.of(1, 2, 3, 4, 6, 10)     // 보너스 번호 + 5개 일치 -> 2등
        ));

        winingLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(10);
    }

    @Test
    void 당첨_여부_확인(){
        LottoResultManager lottoResultManager = new LottoResultManager(winingLotto, bonusNumber);

        LottoResult lottoResult = lottoResultManager.checkLottos(userLottoList);
        Assertions.assertEquals(LottoResult.SECOND.getCount(), 1);
        Assertions.assertEquals(LottoResult.THIRD.getCount(), 1);
        Assertions.assertEquals(LottoResult.FIFTH.getCount(), 1);
        Assertions.assertEquals(LottoResult.FIRST.getCount(), 0);
    }



}
