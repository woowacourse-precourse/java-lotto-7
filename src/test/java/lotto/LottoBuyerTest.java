package lotto;

import lotto.money.Money;
import lotto.store.LottoStoreStub;
import lotto.winner.LottoRank;
import lotto.winner.TestWinningNumbers;
import lotto.winner.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {
    private LottoStoreStub storeStub;

    @BeforeEach
    void beforeEach() {
        storeStub = new LottoStoreStub();
    }

    @DisplayName("로또를 살 수 없다면 예외가 발생한다.")
    @Test
    void test1() {
        storeStub.setSoldLottos(Collections.EMPTY_LIST);

        assertThrows(IllegalArgumentException.class,
                () -> new LottoBuyer(storeStub, money())
        );
    }

    @DisplayName("구매한 로또의 결과를 확인할 수 있다.")
    @Test
    void test2() {
        WinningNumbers winningNumbers = TestWinningNumbers.create();
        storeStub.setSoldLottos(List.of(
                TestWinningNumbers.SECOND_LOTTO,
                TestWinningNumbers.FIFTH_LOTTO
        ));
        LottoBuyer buyer = new LottoBuyer(storeStub, money());

        List<LottoRank> result = buyer.result(winningNumbers);

        assertTrue(result.containsAll(List.of(LottoRank.SECOND, LottoRank.FIFTH)));
    }

    private static Money money() {
        return money(0);
    }

    private static Money money(int amonut) {
        return new Money(amonut);
    }


}