package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResultManager;
import lotto.model.enums.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    private List<Lotto> userLottoList;
    private Lotto winingLotto;
    private BonusNumber bonusNumber;
    private Integer price;

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
        price = 4_000;
    }

    @Test
    @DisplayName("로또 당첨 여부를 확인합니다.")
    void 당첨_여부_확인() {
        LottoResultManager lottoResultManager = new LottoResultManager(winingLotto, bonusNumber, price);

        lottoResultManager.checkLottos(userLottoList);
        assertEquals(1, LottoResult.SECOND.getCount());
        assertEquals(1, LottoResult.THIRD.getCount());
        assertEquals(1, LottoResult.FIFTH.getCount());
        assertEquals(0, LottoResult.FIRST.getCount());
    }

    @Test
    @DisplayName("로또 당첨 금액을 확인합니다.")
    void 당첨_금액_확인() {
        LottoResultManager lottoResultManager = new LottoResultManager(winingLotto, bonusNumber, price);

        lottoResultManager.checkLottos(userLottoList);
        assertEquals(31_505_000, LottoResult.getTotalPrize());
    }

    @Test
    @DisplayName("로또 수익률을 계산합니다.")
    void 수익률_계산() {
        LottoResultManager lottoResultManager = new LottoResultManager(winingLotto, bonusNumber, price);

        lottoResultManager.checkLottos(userLottoList);
        Double profit = lottoResultManager.calculateProfit();
        assertEquals(787625.00, profit);
    }


}
