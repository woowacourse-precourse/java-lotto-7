package lotto.domain;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 생성기 테스트")
class LottoGeneratorTest {

    @DisplayName("로또 생성 시 주어진 개수만큼 로또 번호들을 생성한다.")
    @Test
    void 주어진_개수만큼_로또_번호들을_생성한다() {
        // given
        int lottoCount = 6;
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        // when
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);

        // then
        assertEquals(lottos.size(), lottoCount);
    }

    @DisplayName("로또 생성 시 1 이상 45 이하의 숫자들로 구성된 로또를 생성한다.")
    @Test
    void 로또_생성_시_1_이상_45_이하의_숫자들로_구성된_로또를_생성한다() {
        // given
        int lottoCount = 5;
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        // when
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);

        // then
        lottos.forEach(lotto -> lotto.getNumbers().forEach(number -> {
            assertTrue(number >= 1);
            assertTrue(number <= 45);
        }));
    }
}