package lotto.model.statistic;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecoveryRatioTest {

    @DisplayName("회수율 검증")
    @ParameterizedTest
    @CsvSource({
            "500000000, 50000, 1000000.0",
            "5000, 8000, 62.5",
            "200000000, 8000, 2500000.0",
            "5000, 30000, 16.7",
            "0, 5000, 0.0",
            "10000, 5000, 200.0"
    })
    void validateRecoveryRatio(long totalPrizeAmountValue, long purchasedAmountValue, String expectedRatio) {
        // given
        Money totalPrizeAmount = Money.from(totalPrizeAmountValue);
        Money purchasedAmount = Money.from(purchasedAmountValue);

        // when
        RecoveryRatio actual = RecoveryRatio.of(
                totalPrizeAmount.toBigDecimal(),
                purchasedAmount.toBigDecimal()
        );

        // then
        RecoveryRatio expected = RecoveryRatio.from(new BigDecimal(expectedRatio));
        assertThat(actual.equals(expected)).isTrue();
    }

    @DisplayName("회수율 출력 검증")
    @ParameterizedTest
    @CsvSource(value = {
            "62.5: 62.5%",
            "16.7: 16.7%",
            "0.0: 0.0%",
            "1000000.0: 1,000,000.0%"
    }, delimiter = ':')
    void validateRecoveryRatioToString(String ratioArgs, String expected) {
        // given
        BigDecimal ratioDecimal = new BigDecimal(ratioArgs);
        RecoveryRatio recoveryRatio = RecoveryRatio.from(ratioDecimal);

        // when
        String actual = recoveryRatio.toString();

        // then
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}
