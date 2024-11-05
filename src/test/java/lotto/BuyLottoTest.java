package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.item.Money;
import lotto.model.BuyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyLottoTest {
    @Test
    @DisplayName("정상적인 값 입력(8000원이 들어가면 lotto 8개를 뽑는다.)")
    void 정상값테스트_로또개수_확인() {
        assertThat(new BuyLotto(new Money("8000")).getDataUserLotto().size())
                .isEqualTo(8);
    }

    @Test
    @DisplayName("정상적인 값 입력(로또의 숫자는 6개이다.)")
    void 정상값테스트_로또숫자_6개_확인() {
        List<List<Integer>> lottoData = new ArrayList<>();
        lottoData = new BuyLotto(new Money("8000")).getDataUserLotto();
        for(int i = 0; i<8; i++) {
            assertThat(lottoData.get(i).size())
                    .isEqualTo(6);
        };
    }
}
