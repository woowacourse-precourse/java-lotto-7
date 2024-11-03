package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellerTest {
    @DisplayName("주어진 로또 번호를 가진 LottoTicket을 생성한다.")
    @Test
    void createLottoTicketWith() {
        LottoSeller lottoSeller = LottoSellerFixture.createLottoSeller();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> expectedLottos = List.of(new Lotto(numbers));

        LottoTicket actual = lottoSeller.createLottoTicketFor(numbers);
        List<Lotto> actualLottos = actual.lottos();

        assertThat(actualLottos)
                .isNotNull()
                .hasSameSizeAs(expectedLottos)
                .usingRecursiveComparison()
                .isEqualTo(expectedLottos);
    }

    @DisplayName("로또 1개 가격이 1,000원일 때, 구입 금액에 따라 구매한 수량과 크기가 같은 LottoTicket을 생성한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "1000,1", "8000,8", "10000000,10000", "950000000,950000"})
    void createLottoTicketHasSameSizeWithPurchaseQuantity(BigInteger purchaseAmount, int expectedQuantity) {
        LottoSeller lottoSeller = LottoSellerFixture.createLottoSeller();

        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(purchaseAmount);
        int actualQuantity = lottoTicket.lottos().size();

        assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }

    @DisplayName("로또 1개 가격과 구입 금액을 기준으로 구매한 수량과 크기가 같은 LottoTicket을 생성한다.")
    @ParameterizedTest
    @CsvSource({"5000,0,0", "10000,70000,7", "1,8000,8000", "30000,360000,12", "100,95000000,950000"})
    void createLottoTicketBy(int lottoPrice, BigInteger purchaseAmount, int expectedQuantity) {
        LottoMachine lottoMachine = LottoMachineFixture.createLottoMachine();
        LottoSeller lottoSeller = new LottoSeller(lottoPrice, lottoMachine);

        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(purchaseAmount);
        int actualQuantity = lottoTicket.lottos().size();

        assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }
}