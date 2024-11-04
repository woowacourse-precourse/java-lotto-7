package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.vo.PurchaseAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoVendingMachineTests {
    private static class FixedLottoNumberGenerator implements LottoNumberGenerator {
        @Override
        public List<Integer> generateLottoNumbers() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_PRICE, LOTTO_PRICE * 5, LOTTO_PRICE * 10})
    void testPurchaseGeneratesCorrectNumberOfLottos(int purchaseAmountValue) {
        LottoNumberGenerator fixedGenerator = new FixedLottoNumberGenerator();
        LottoVendingMachine vendingMachine = new LottoVendingMachine(fixedGenerator);
        PurchaseAmount purchaseAmount = PurchaseAmount.of(purchaseAmountValue);

        PurchasedLottos purchasedLottos = vendingMachine.purchase(purchaseAmount);

        int expectedLottoCount = purchaseAmountValue / LOTTO_PRICE;
        List<Lotto> extractedLottos = purchasedLottos.getLottosAsUnmodifiableList();
        assertThat(extractedLottos).hasSize(expectedLottoCount);
        assertThat(extractedLottos).allSatisfy(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbersAsUnmodifiableList();
            assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }
}