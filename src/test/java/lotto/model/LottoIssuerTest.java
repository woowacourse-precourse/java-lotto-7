package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {
    @Test
    @DisplayName("사용자가 입력한 구매 입력으로 로또 발행 개수 계산해 로또 발행 테스트")
    void issueLottoTest() {
        int purchaseAmount = 14000;
        int expectedLottoCount = 14;

        int purchaseCount = LottoIssueCount.calculateNumberOfLottoIssue(purchaseAmount);
        int actualLottoCount = LottoIssuer.issueLotto(purchaseCount).size();

        assertEquals(expectedLottoCount, actualLottoCount);
    }
}