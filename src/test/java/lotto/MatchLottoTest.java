package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.item.AdditionalNumber;
import lotto.item.Lotto;
import lotto.item.Money;
import lotto.model.BuyLotto;
import lotto.model.MatchLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchLottoTest {
    @Test
    @DisplayName("당첨금 확인")
    void 당첨금_확인() {
        Money money = new Money("1000000");
        BuyLotto buyLotto = new BuyLotto(money);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        AdditionalNumber additionalNumber = new AdditionalNumber("7"); // 보너스 번호
        MatchLotto matchLotto = new MatchLotto();

        HashMap<Integer, Integer> result = matchLotto.MatchLotto(buyLotto, winningLotto, additionalNumber);
        assertThat(result.get(5000)).isGreaterThanOrEqualTo(0);
        assertThat(result.get(50000)).isGreaterThanOrEqualTo(0);
        assertThat(result.get(1500000)).isGreaterThanOrEqualTo(0);
        assertThat(result.get(30000000)).isGreaterThanOrEqualTo(0);
        assertThat(result.get(2000000000)).isGreaterThanOrEqualTo(0);
    }
}
