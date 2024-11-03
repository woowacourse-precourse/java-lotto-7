package lotto;

import lotto.money.Money;
import lotto.store.LottoStoreStub;
import lotto.store.lotto.LottoRank;
import lotto.ui.LottoResult;
import lotto.store.lotto.TestWinningNumbers;
import lotto.ui.WinningNumberSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoProgramTest {

    private LottoProgram lottoProgram;
    private LottoStoreStub lottoStoreStub;
    private final WinningNumberSettings testSettings = new WinningNumberSettings(
            TestWinningNumbers.testBonusInt,
            TestWinningNumbers.testLottoInts
    );

    @BeforeEach
    void beforeEach() {
        lottoStoreStub = new LottoStoreStub();
        lottoProgram = new LottoProgram(lottoStoreStub);
    }

    @DisplayName("사용자 입력으로 구매한 로또의 결과를 반환함")
    @Test
    void test1() {
        lottoStoreStub.setSoldLottos(List.of(
                TestWinningNumbers.FIFTH_LOTTO,
                TestWinningNumbers.FOURTH_LOTTO
        ));
        int money = 1;

        LottoResult result = lottoProgram.start(new Money(money), testSettings);

        assertThat(result.getBuyerLottoRanks()).contains(LottoRank.FIFTH, LottoRank.FOURTH);
        assertThat(result.getRateOfReturn()).isEqualTo(5000 + 50_000);
    }

}