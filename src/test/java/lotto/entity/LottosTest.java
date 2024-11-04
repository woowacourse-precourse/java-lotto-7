package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Nested
    @DisplayName("로또 뭉치 생성 Test")
    class CreateLottosTest {

        @DisplayName("로또 구입 테스트")
        @Test
        void buyLottosTest() {
            Lottos lottos = new Lottos();
            lottos.buyLottos(10000L);
            List<Lotto> lottoList = lottos.getLottos();

            assertEquals(lottoList.size(), 10);
        }

        @DisplayName("로또 invalid 비용 테스트 (1000원 이하)")
        @Test
        void buyLottosError1() {
            // 1000원 이하
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(10L))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 invalid 비용 테스트 (not 1000원 단위)")
        @Test
        void buyLottosError2() {
            // 1000원 단위 아님
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(100010L))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 invalid 비용 테스트 (int 자료형 초과)")
        @Test
        void buyLottosError3() {
            // 1000원 이하
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(50000000000L))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
