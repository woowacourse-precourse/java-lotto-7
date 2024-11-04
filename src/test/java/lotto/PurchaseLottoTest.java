package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.PurchaseLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoTest {
    private final PurchaseLotto purchaseLotto = new PurchaseLotto();

    @Test
    @DisplayName("로또 구매 금액이 1,000으로 나누어떨어지지 않는 경우 예외 발생 테스트")
    void 로또_구매_금액_1000으로_나누어떨어지지_않는_경우_예외테스트() {
        assertThatThrownBy(() -> purchaseLotto.setPurchaseCount(10001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 구매 수량 계산 기능 테스트")
    void 로또_구매_가능_수량_계산_기능_테스트() {
        assertThat(purchaseLotto.setPurchaseCount(5000))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("로또 구매 가능 수량 발매 테스트")
    void 로또_구매_가능_수량만큼_발매_확인_테스트() {
        purchaseLotto.issueLotto(purchaseLotto.setPurchaseCount(5000));
        assertThat(purchaseLotto.getPurchasedLottos().size())
                .isEqualTo(5);
    }
}
