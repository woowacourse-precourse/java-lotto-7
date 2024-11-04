package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {

    @Test
    public void 로또_번호_발행_테스트() {
        LottoManager lottoManager = new LottoManager();
        List<Lotto> lottos = lottoManager.generateLottos(5);

        // 5개의 로또가 생성되었는지 확인
        assertThat(lottos).hasSize(5);
        // 각 로또 번호가 6개이고 1~45 사이의 숫자인지 확인
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            for (int number : lotto.getNumbers()) {
                assertThat(number).isBetween(1, 45);
            }
        }
    }
}
