package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;

class PurchasedLottoTest {

    @Test
    void 구매자_로또_생성_성공() {
        // Given
        int expectedQuantity = 5;

        // When
        PurchasedLotto lottoManager = new PurchasedLotto(expectedQuantity);

        // Then
        assertThat(lottoManager.getLottos().size()).isEqualTo(expectedQuantity);
    }

    @Test
    void 구매자_로또_숫자_개수_성공() {
        // Given
        int expectedLottoSize = 6;
        PurchasedLotto purchasedLotto = new PurchasedLotto(3);

        // When & Then
        purchasedLotto.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers().size()).isEqualTo(expectedLottoSize)
        );
    }

    @Test
    void 구매자_로또_숫자_범위_검증_성공() {
        // Given
        int minRange = 1;
        int maxRange = 45;
        PurchasedLotto purchasedLotto = new PurchasedLotto(3);

        // When & Then
        purchasedLotto.getLottos().forEach(lotto ->
                lotto.getNumbers().forEach(number -> {
                    assertThat(number).isBetween(minRange, maxRange);
                })
        );
    }

    @Test
    void 구매자_로또_숫자_중복_검증_성공() {
        // Given
        PurchasedLotto purchasedLotto = new PurchasedLotto(3);

        // When & Then
        purchasedLotto.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

            assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());
        });
    }

}