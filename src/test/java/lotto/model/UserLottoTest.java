package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;

class UserLottoTest {

    @Test
    void 구매자_로또_생성_성공() {
        // Given
        int expectedQuantity = 5;

        // When
        UserLotto lottoManager = new UserLotto(expectedQuantity);

        // Then
        assertThat(lottoManager.getLottos().size()).isEqualTo(expectedQuantity);
    }

    @Test
    void 구매자_로또_숫자_개수_성공() {
        // Given
        int expectedLottoSize = 6;
        UserLotto userLotto = new UserLotto(3);

        // When & Then
        userLotto.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers().size()).isEqualTo(expectedLottoSize)
        );
    }

    @Test
    void 구매자_로또_숫자_범위_검증_성공() {
        // Given
        int minRange = 1;
        int maxRange = 45;
        UserLotto userLotto = new UserLotto(3);

        // When & Then
        userLotto.getLottos().forEach(lotto ->
                lotto.getNumbers().forEach(number -> {
                    assertThat(number).isBetween(minRange, maxRange);
                })
        );
    }

    @Test
    void 구매자_로또_숫자_중복_검증_성공() {
        // Given
        UserLotto userLotto = new UserLotto(3);

        // When & Then
        userLotto.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

            assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());
        });
    }

}