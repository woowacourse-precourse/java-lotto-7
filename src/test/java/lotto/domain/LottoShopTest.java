package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    private final LottoShop lottoShop = new LottoShop();

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 3500, 4200, 10001, Integer.MAX_VALUE})
    void 로또구입_금액이_천원단위가_아니면_예외발생(int money) {
        assertThatThrownBy(() -> lottoShop.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 999})
    void 로또구입_금액이_천원미만이면_예외발생(int money) {
        assertThatThrownBy(() -> lottoShop.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1,000원 입니다.");
    }

}