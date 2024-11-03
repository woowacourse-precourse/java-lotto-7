package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoReceiptTest {
    @DisplayName("총 수익률을 계산하고 소수점 둘째 자리에서 반올림한다.")
    @ParameterizedTest
    @MethodSource
    void calculateRateOfReturnBy(BigInteger totalAmount, BigInteger totalPrize, BigDecimal expected) {
        LottoTicket lottoTicket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        LottoReceipt lottoReceipt = new LottoReceipt(totalAmount, lottoTicket);

        BigDecimal actual = lottoReceipt.calculateRateOfReturn(totalPrize);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> calculateRateOfReturnBy() {
        return Stream.of(
                Arguments.of(new BigInteger("14000"), new BigInteger("0"), new BigDecimal("0.0")),
                Arguments.of(new BigInteger("8000"), new BigInteger("5000"), new BigDecimal("62.5")),
                Arguments.of(new BigInteger("3000"), new BigInteger("1234567"), new BigDecimal("41152.2")),
                Arguments.of(new BigInteger("5000"), new BigInteger("4555000"), new BigDecimal("91100.0")),
                Arguments.of(new BigInteger("18000"), new BigInteger("2000125000"), new BigDecimal("11111805.6")));
    }
}