package lotto.store;

import lotto.money.Money;
import lotto.store.lotto.Lotto;
import lotto.store.lotto.winner.LottoRank;
import lotto.store.lotto.winner.TestWinningNumbers;
import lotto.store.lotto.winner.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("구매한 로또의 수익률을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("rateOfReturnOptions")
    void test3(double expectedRate, Money seedMoney, List<Lotto> soldLottos) {
        WinningNumbers winningNumbers = TestWinningNumbers.create();
        storeStub.setSoldLottos(soldLottos);

        LottoBuyer buyer = new LottoBuyer(storeStub, seedMoney);

        assertEquals(buyer.rateOfReturn(winningNumbers),expectedRate);
    }

    static Stream<Arguments> rateOfReturnOptions() {
        return Stream.of(
                Arguments.of(2.0, LottoRank.FIFTH.price(),
                        List.of(TestWinningNumbers.FIFTH_LOTTO, TestWinningNumbers.FIFTH_LOTTO)),
                Arguments.of(10.0, money(5_000),
                        List.of(TestWinningNumbers.FOURTH_LOTTO))
        );
    }

    private static Money money() {
        return money(0);
    }

    private static Money money(int amonut) {
        return new Money(amonut);
    }


}