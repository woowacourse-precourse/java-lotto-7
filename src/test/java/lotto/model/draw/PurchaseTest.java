package lotto.model;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.purchase.Lotto;
import lotto.model.purchase.Purchase;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @Test
    void 금액에_맞는_개수의_로또를_발행한다() {
        // given
        String paymentInput = "8000";

        // when
        Purchase purchase = new Purchase(paymentInput);
        int lottoCount = purchase.calculateLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    void 발행된_로또번호는_중복이아닌_6개의_범위내의숫자이다() {
        // given
        String paymentInput = "10000";

        // when
        Purchase purchase = new Purchase(paymentInput);
        List<Lotto> lottoTickets = purchase.getPurchasedLottoTickets();

        // then
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(LOTTO_NUMBER_COUNT);
            assertThat(numbers).allMatch(
                    number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }
}
