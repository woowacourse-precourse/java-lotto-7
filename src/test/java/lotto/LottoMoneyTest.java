package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoMoneyTest {
    @Test
    @DisplayName("로또 구매 금액은 음수면 안된다.")
    public void getMoneyForLotto_negativeException(){
        //given
        int money = -1000;

        assertThatThrownBy(() -> LottoGenerator.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 금액은 1,000단위로 나뉘어 떨어져야 한다..")
    public void getMoneyForLotto_DivideException(){
        //given
        int money = 1500;

        assertThatThrownBy(() -> LottoGenerator.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 금액이 2,000원일 때 정상적으로 금액이 저장된다..")
    public void getMoneyForLotto_Success() {
        // given
        int money = 2000;

        // when
        LottoGenerator lottoGenerator = LottoGenerator.of(money);

        // then
        assertThat(lottoGenerator.getMoney()).isEqualTo(2000);
    }


}
