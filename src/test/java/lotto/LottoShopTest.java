package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.item.Lotto;
import lotto.item.WinningLotto;
import lotto.numberSelector.RandomSelector;
import lotto.shop.LottoShop;
import org.junit.jupiter.api.Test;

class LottoShopTest extends NsTest {

    private LottoShop lottoShop = new LottoShop();

    @Test
    void buy() {
        int inputMoney = 8000;
        assertThat(lottoShop.buy(inputMoney, new RandomSelector()).size()).isEqualTo(8);
        assertThat(output()).contains(inputMoney/LottoShop.PRICE + "개를 구매했습니다.");
    }

    @Test
    void makeWinningLotto() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        Lotto result = lottoShop.makeWinningLotto(numbers, bonusNumber);
        assertThat(result).isInstanceOf(WinningLotto.class);
        assertThat(result.getNumbers()).containsExactly(1,2,3,4,5,6);
        WinningLotto downCastResult = (WinningLotto) result;
        assertThat(downCastResult.getBonusNum()).isEqualTo(7);
    }

    @Override
    protected void runMain() {

    }
}