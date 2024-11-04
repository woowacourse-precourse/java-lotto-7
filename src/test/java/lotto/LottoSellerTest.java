package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoSellerTest {

    private LottoSeller lottoSeller;

    @ParameterizedTest
    @CsvSource({"10000,1000,10", "15000, 1000, 15", "101000, 1000, 101"})
    void 구매금액을_로또금액으로_나눈_몫의_개수를_리턴한다(int cash, int lottoPrice, int expectedCount) {
        lottoSeller = new LottoSeller(cash, lottoPrice);
        int lottoCount = lottoSeller.getLottoCount();
        assertEquals(lottoCount, expectedCount);
    }

    @ParameterizedTest
    @CsvSource({"10000,1000,10", "15000, 1000, 15", "101000, 1000, 101"})
    void 구매금액을_로또금액으로_나눈_몫의_개수만큼_로또를_구매한다(int cash, int lottoPrice, int expectedCount) {
        lottoSeller = new LottoSeller(cash, lottoPrice);
        List<Lotto> purchasedLottos = lottoSeller.sell();
        assertEquals(expectedCount, purchasedLottos.size());
    }
}
