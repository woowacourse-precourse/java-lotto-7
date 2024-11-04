package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.lotto.LottoShop;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.utils.LottoNumberPicker;
import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를발행한다")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        // given
        LottoShop lottoShop = new LottoShop(new LottoNumberPicker(), new InputValidation());
        long money = 8000L;

        // when
        List<MyLotto> myLottos = lottoShop.buyLottos(money);

        // then
        assertThat(myLottos.size()).isEqualTo(8);
    }
}
