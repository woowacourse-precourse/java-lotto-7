package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IssuerTest {
    @Test
    @DisplayName("")
    void issueLotteriesTest() {
        Issuer issuer = new Issuer();

        // 테스트할 구입 금액 설정
        int purchaseAmount = 5000; // 5개의 로또가 생성되어야 함
        int expectedCount = purchaseAmount / 1000;

        List<Lotto> issuedLotteries = issuer.getIssuedLotteries(purchaseAmount);

        // 1. 로또의 개수 확인
        assertEquals(expectedCount, issuedLotteries.size());

        // 2. 각 로또가 6개의 번호로 구성되어 있고 중복이 없는지 확인
        for (Lotto lotto : issuedLotteries) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size(), "각 로또에는 6개의 숫자가 있어야 합니다.");

            // Set으로 중복 제거 후 크기 비교하여 중복 확인
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertEquals(6, uniqueNumbers.size(), "각 로또에는 중복 없는 숫자가 있어야 합니다.");

            // 번호가 1~45 범위 내에 있는지 확인
            for (int number : numbers) {
                assertTrue(number >= 1 && number <= 45, "번호는 1~45 범위 내에 있어야 합니다.");
            }
        }
    }
}
