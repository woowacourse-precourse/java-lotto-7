package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @Test
    @DisplayName("올바른 금액 입력 시 금액 만큼의 로또 리스트를 가지고 있다.")
    void 올바른_금액_입력_시_금액_만큼의_로또_리스트를_가지고_있다() {
        int amount = 5000;
        LottoShop lottoShop = new LottoShop(amount);

        List<Lotto> purchasedLotto = lottoShop.getPurChasedLotto();
        assertThat(purchasedLotto).hasSize(5);
    }

    @Test
    @DisplayName("구매한 로또가 번호 6개를 가지고 있다.")
    void 구매한_로또가_번호_6개를_가지고_있다() {
        LottoShop lottoShop = new LottoShop(3000);
        List<Lotto> purchasedLotto = lottoShop.getPurChasedLotto();

        assertThat(purchasedLotto).allSatisfy(lotto ->
                assertThat(lotto.getNumbers()).hasSize(6)
        );
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    void 구입_금액이_숫자가_아닌_경우_예외가_발생한다() {
        String invalidAmount = "abc";
        assertThatThrownBy(() -> LottoShop.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생한다.")
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        String invalidAmount = "1500";
        assertThatThrownBy(() -> LottoShop.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 0원일 경우 예외가 발생한다.")
    void 구입_금액이_0원일_경우_예외가_발생한다() {
        String zeroAmount = "0";
        assertThatThrownBy(() -> LottoShop.validatePurchaseAmount(zeroAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("올바른 금액 입력 시 validatePurchaseAmount 메서드가 올바른 금액을 반환한다.")
    void 올바른_금액_입력_시_validatePurchaseAmount_메서드가_올바른_금액을_반환한다() {
        String validAmount = "3000";
        int amount = LottoShop.validatePurchaseAmount(validAmount);
        assertThat(amount).isEqualTo(3000);
    }

}