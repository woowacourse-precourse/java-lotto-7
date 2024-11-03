package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPlayerTest {

    @DisplayName("로또 번호를 구매할 때, 구입 금액에 따라 로또 수량이 결정된다.")
    @Test
    void purchaseTest() {
        // Given
        LottoPlayer lottoPlayer = new LottoPlayer();
        int purchaseAmount = 8000; // 8장 구매

        // When
        List<Lotto> purchasedLottos = lottoPlayer.purchase(purchaseAmount);

        // Then
        assertThat(purchasedLottos).hasSize(8); // 8개의 로또 번호가 생성되어야 함
    }

    @DisplayName("구매한 로또 번호는 중복되지 않아야 한다.")
    @Test
    void uniqueNumbersTest() {
        // Given
        LottoPlayer lottoPlayer = new LottoPlayer();
        int purchaseAmount = 5000; // 5장 구매

        // When
        List<Lotto> purchasedLottos = lottoPlayer.purchase(purchaseAmount);

        // Then
        purchasedLottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6); // 각 로또는 6개의 숫자를 가져야 함
            assertThat(numbers).doesNotHaveDuplicates(); // 중복된 숫자가 없어야 함
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45); // 숫자는 1~45 사이여야 함
        });
    }
}