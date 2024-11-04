package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.LottoErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Nested
    class issueLottos_메소드_테스트 {
        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 5000})
        void 금액이_로또_가격의_배수면_정상적으로_로또가_발행된다(int money) {
            int expectedLottoCount = money / LottoConstant.LOTTO_PRICE;
            List<Lotto> issuedLottos = lottoMachine.issueLottos(money);

            assertThat(issuedLottos).hasSize(expectedLottoCount);
            issuedLottos.forEach(lotto ->
                    assertThat(lotto.getNumbers()).hasSize(LottoConstant.LOTTO_NUMBER_COUNT));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1000})
        void 금액이_0이하이면_예외가_발생한다(int invalidMoney) {
            assertThatThrownBy(() -> lottoMachine.issueLottos(invalidMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorMessage.LOTTO_MONEY_TOO_LOW.message);
        }

        @ParameterizedTest
        @ValueSource(ints = {1500, 2500})
        void 금액이_로또_가격의_배수가_아니면_예외가_발생한다(int invalidMoney) {
            assertThatThrownBy(() -> lottoMachine.issueLottos(invalidMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorMessage.LOTTO_MONEY_INVALID_UNIT.message);
        }
    }

    @Nested
    class calculateLottoPrice_메소드_테스트 {
        @Test
        void 로또_당첨_결과를_정확히_계산한다() {
            List<Lotto> lottos = List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),    // 1등 예상
                    new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 2등 예상 (보너스 번호 일치)
                    new Lotto(List.of(1, 2, 3, 4, 5, 8)),    // 3등 예상
                    new Lotto(List.of(1, 2, 3, 4, 9, 10)),   // 4등 예상
                    new Lotto(List.of(1, 2, 3, 11, 12, 13))  // 5등 예상
            );

            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;

            HashMap<LottoPrice, Integer> expectedPrices = new HashMap<>();
            expectedPrices.put(LottoPrice.FIRST, 1);
            expectedPrices.put(LottoPrice.SECOND, 1);
            expectedPrices.put(LottoPrice.THIRD, 1);
            expectedPrices.put(LottoPrice.FOURTH, 1);
            expectedPrices.put(LottoPrice.FIFTH, 1);

            HashMap<LottoPrice, Integer> calculatedPrices = lottoMachine.calculateLottoPrice(lottos, winningLotto,
                    bonusNumber);

            assertThat(calculatedPrices).containsExactlyInAnyOrderEntriesOf(expectedPrices);
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 6, 7, FIRST",
                "1, 2, 3, 4, 5, 8, 7, THIRD",
                "1, 2, 3, 4, 9, 10, 7, FOURTH",
                "1, 2, 3, 11, 12, 13, 7, FIFTH"
        })
        void 로또_당첨_등급을_정확히_계산한다(int n1, int n2, int n3, int n4, int n5, int n6, int bonusNumber,
                                LottoPrice expectedPrice) {
            Lotto lotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            HashMap<LottoPrice, Integer> prices = lottoMachine.calculateLottoPrice(List.of(lotto), winningLotto,
                    bonusNumber);

            assertThat(prices).containsEntry(expectedPrice, 1);
        }
    }
}