package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUpWinningLotto() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        winningLotto = new WinningLotto(
                lotto, new Bonus("7", lotto)
        );
    }

    @Nested
    @DisplayName("당첨 결과 생성 테스트")
    class whenGetWinning {

        @Test
        @DisplayName("아무것도 당첨되지 않은 경우")
        void whenEmptyPrizeReturnAllZero() {
            //given
            List<Lotto> buyingLottos = List.of(new Lotto("1,2,8,9,10,11"));

            Map<Prize, Integer> expected = new LinkedHashMap<>();
            expected.put(Prize.FIFTH_PRIZE, 0);
            expected.put(Prize.FOURTH_PRIZE, 0);
            expected.put(Prize.THIRD_PRIZE, 0);
            expected.put(Prize.SECOND_PRIZE, 0);
            expected.put(Prize.FIRST_PRIZE, 0);

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            Map<Prize, Integer> actual = winningResult.getWinning();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("모두 하나씩 당첨되는 경우")
        void whenAllPrizeReturnAllOne() {
            //given
            List<Lotto> buyingLottos = List.of(
                    new Lotto("1,2,3,4,5,6"), // 1등
                    new Lotto("1,2,3,4,5,7"), // 2등
                    new Lotto("1,2,3,4,5,8"), // 3등
                    new Lotto("1,2,3,4,8,9"), // 4등
                    new Lotto("1,2,3,8,9,10") // 5등
            );

            Map<Prize, Integer> expected = new LinkedHashMap<>();
            expected.put(Prize.FIFTH_PRIZE, 1);
            expected.put(Prize.FOURTH_PRIZE, 1);
            expected.put(Prize.THIRD_PRIZE, 1);
            expected.put(Prize.SECOND_PRIZE, 1);
            expected.put(Prize.FIRST_PRIZE, 1);

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            Map<Prize, Integer> actual = winningResult.getWinning();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("최대 금액으로 최대 당첨금이 나오는 경우")
        void whenMaxPurchaseAmountReturnMaxFirstPrizeCount() {
            //given
            int maxBuyingLottoCount = 2147483;
            List<Lotto> buyingLottos = IntStream.range(0, maxBuyingLottoCount)
                    .mapToObj(i -> new Lotto("1,2,3,4,5,6"))
                    .toList();

            Map<Prize, Integer> expected = new LinkedHashMap<>();
            expected.put(Prize.FIFTH_PRIZE, 0);
            expected.put(Prize.FOURTH_PRIZE, 0);
            expected.put(Prize.THIRD_PRIZE, 0);
            expected.put(Prize.SECOND_PRIZE, 0);
            expected.put(Prize.FIRST_PRIZE, maxBuyingLottoCount);

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            Map<Prize, Integer> actual = winningResult.getWinning();

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("수익률 생성 테스트")
    class whenGetRateOfReturn {

        @Test
        @DisplayName("아무것도 당첨되지 않은 경우")
        void whenEmptyPrizeReturnAllZero() {
            //given
            PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
            List<Lotto> buyingLottos = List.of(new Lotto("1,2,8,9,10,11"));

            double expected = 0;

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            double actual = winningResult.getRateOfReturn(purchaseAmount);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("모두 하나씩 당첨되는 경우")
        void whenAllPrizeReturnAllOne() {
            //given
            PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
            List<Lotto> buyingLottos = List.of(
                    new Lotto("1,2,3,4,5,6"), // 1등
                    new Lotto("1,2,3,4,5,7"), // 2등
                    new Lotto("1,2,3,4,5,8"), // 3등
                    new Lotto("1,2,3,4,8,9"), // 4등
                    new Lotto("1,2,3,8,9,10") // 5등
            );

            double expected = 40631100;

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            double actual = winningResult.getRateOfReturn(purchaseAmount);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("최대 금액으로 최대 당첨금이 나오는 경우")
        void whenMaxPurchaseAmountReturnMaxPercent() {
            //given
            PurchaseAmount purchaseAmount = new PurchaseAmount("2147483000");
            int maxBuyingLottoCount = purchaseAmount.getPurchaseAmount();
            List<Lotto> buyingLottos = IntStream.range(0, maxBuyingLottoCount)
                    .mapToObj(i -> new Lotto("1,2,3,4,5,6"))
                    .toList();

            double expected = 200000000;

            //when
            WinningResult winningResult = new WinningResult(winningLotto, buyingLottos);
            double actual = winningResult.getRateOfReturn(purchaseAmount);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

}
