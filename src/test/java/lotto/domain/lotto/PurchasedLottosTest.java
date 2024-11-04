package lotto.domain.lotto;

import lotto.global.constant.LottoConstant;
import lotto.global.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasedLottosTest {

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2200, 1100, 999})
    void should_ThrowException_When_PurchaseAmountNotDivisibleByPrice(int purchaseAmount) {
        assertThatThrownBy(() -> PurchasedLottos.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구매 금액이 0 이하이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -2000})
    void should_ThrowException_When_PurchaseAmountIsZeroOrNegative(int purchaseAmount) {
        assertThatThrownBy(() -> PurchasedLottos.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REQUIRED_POSITIVE_NUMBER.getMessage());
    }

    @DisplayName("구매 금액에 맞게 로또가 발급되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 7000})
    void should_GenerateCorrectNumberOfLottos_When_PurchaseAmountGiven(int purchaseAmount) {
        // given
        int expectedLottoCount = purchaseAmount / LottoConstant.LOTTO_PRICE;

        // when
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchaseAmount);

        // then
        assertThat(purchasedLottos.getPurchasedLottos()).hasSize(expectedLottoCount);
    }

    @DisplayName("발급된 로또는 불변이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 7000})
    void should_ThrowException_When_TryingToModifyPurchasedLottos(int purchaseAmount) {
        // given
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchaseAmount);
        List<Lotto> lottos = purchasedLottos.getPurchasedLottos();

        // when & then
        assertThatThrownBy(() -> lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("발급된 각 로또는 6개의 숫자를 가져야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 7000})
    void should_HaveSixNumbers_When_PurchaseEachLottos(int purchaseAmount) {
        // given
        PurchasedLottos purchasedLottos = PurchasedLottos.from(purchaseAmount);

        // when & then
        assertThat(purchasedLottos.getPurchasedLottos())
                .allMatch(lotto -> lotto.getNumbers().size() == LottoConstant.LOTTO_SIZE);
    }
}