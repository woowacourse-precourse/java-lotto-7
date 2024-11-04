package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {

    @DisplayName("구입금액 / 1000 만큼의 로또가 들어가있는 로또 티켓이 생성되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "12000, 12", "100000, 100"})
    void purchaseLottoTicket(int purchaseAmount, int expected) {

        LottoTicket lottoTicket = LottoStore.purchaseLottoTicket(purchaseAmount);

        assertThat(lottoTicket.getLottoCount()).isEqualTo(expected);
    }
}