package lotto.domain;

import static lotto.MessageContainer.ERROR_MESSAGE;
import static lotto.MessageContainer.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {
    @DisplayName("로또 1개 가격이 1,000원일 때, 구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, 1001, 1900, 12345, 1999999999})
    void throwIllegalArgumentExceptionIfNotMutiplesOfLottoPriceOrZero(int intAmount) {
        LottoSeller lottoSeller = LottoSellerFixture.createLottoSeller();
        BigInteger bigIntegerAmount = BigInteger.valueOf(intAmount);

        assertThatThrownBy(() -> lottoSeller.sellAsMuchAs(bigIntegerAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE)
                .hasMessage(INVALID_PURCHASE_AMOUNT);
    }

    @DisplayName("로또 1개 가격이 1,000원일 때, 구입 금액이 1,000원 단위가 맞으면 LottoReceipt 인스턴스를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 19000, 1000000000, 1234500000, 1999999000})
    void createLottoReceiptIfMutiplesOfLottoPrice(int intAmount) {
        LottoSeller lottoSeller = LottoSellerFixture.createLottoSeller();
        BigInteger bigIntegerAmount = BigInteger.valueOf(intAmount);

        assertThatCode(() -> lottoSeller.sellAsMuchAs(bigIntegerAmount))
                .doesNotThrowAnyException();
        assertThat(lottoSeller.sellAsMuchAs(bigIntegerAmount))
                .isInstanceOf(LottoReceipt.class)
                .isNotNull()
                .hasFieldOrPropertyWithValue("totalAmount", bigIntegerAmount);
    }

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
    void createLottoTicketBy(BigInteger lottoPrice, BigInteger purchaseAmount, int expectedQuantity) {
        LottoMachine lottoMachine = LottoMachineFixture.createLottoMachine();
        LottoSeller lottoSeller = new LottoSeller(lottoPrice, lottoMachine);

        LottoTicket lottoTicket = lottoSeller.createLottoTicketFor(purchaseAmount);
        int actualQuantity = lottoTicket.lottos().size();

        assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }
}