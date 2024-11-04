package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.lotto.LottoShop;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.utils.LottoNumberPicker;
import lotto.validation.MoneyValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("구입_금액에_해당하는_만큼_로또를_발행한다")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        LottoShop lottoShop = new LottoShop(new LottoNumberPicker(), new MoneyValidation());
        long money = 8000L;

        // when
        List<MyLotto> myLottos = lottoShop.buyLottos(money);

        // then
        assertThat(myLottos.size()).isEqualTo(8);
    }

    @DisplayName("입력한 금액이 1,000원 단위가 아니라면 예외가 발생한다")
    @Test
    void 입력한_금액이_1000원_단위가_아니라면_예외가_발생한다() {
        // given
        LottoShop lottoShop = new LottoShop(new LottoNumberPicker(), new MoneyValidation());
        long money = 1234L;

        // when & then
        assertThatThrownBy(() -> lottoShop.buyLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
