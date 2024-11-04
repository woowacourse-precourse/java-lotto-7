package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPublicTest {

    @Test
    @DisplayName("5000원을 입력했을 때 5개의 로또 객체가 생성되는지 확인한다.")
    public void lottoPublicWithMoney() {
        // given
        int money = 5000;
        LottoGenerator lottoGenerator = LottoGenerator.of(money);

        // when
        List<Lotto> lottos = lottoGenerator.publicLottos();

        // then
        assertThat(lottos).hasSize(5);
    }
}
