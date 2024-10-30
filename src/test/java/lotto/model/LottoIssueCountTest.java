package lotto.model;

import static lotto.model.LottoIssueCount.calculateNumberOfLottoIssue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoIssueCountTest {

    @ParameterizedTest
    @DisplayName("로또 발행 개수 계산")
    @CsvSource({"1000, 1", "2000, 2", "3000, 3", "4000, 4", "5000, 5", "10000, 10", "100000, 100"})
    void purchaseInputLottoIssue(int lottoPurchaseAmount, int expected) {
        int result = calculateNumberOfLottoIssue(lottoPurchaseAmount);
        assertEquals(result, expected);
    }



}