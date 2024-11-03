package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    @DisplayName("구입 금액이 양수가 아닌 경우 예외 발생 테스트")
    void 구입_금액이_양수가_아닐_때_예외_발생(int amount) {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount),
                "[ERROR] 구입 금액은 양수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 1500, 2500})
    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외 발생 테스트")
    void 구입_금액이_천원_단위가_아닐_때_예외_발생(int amount) {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(amount),
                "[ERROR] 구입 금액은 1,000원 단위의 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    @DisplayName("유효한 구입 금액일 때 예외 발생하지 않음")
    void 유효한_구입_금액일_때_예외_미발생(int amount) {
        assertDoesNotThrow(() -> new PurchaseAmount(amount));
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "5000, 5", "10000, 10"})
    @DisplayName("구입 금액에 따라 로또 개수 계산 테스트")
    void 로또_개수_계산_테스트(int amount, int expectedCount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        int lottoCount = purchaseAmount.calculateLottoCount();
        assertThat(lottoCount).isEqualTo(expectedCount);
    }
}