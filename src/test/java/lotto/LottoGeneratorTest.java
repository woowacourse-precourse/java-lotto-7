package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 생성 테스트")
public class LottoGeneratorTest {
    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new RandomLottoGenerator();
    }

    @Test
    @DisplayName("구입 금액에 맞게 로또를 생성한다.")
    void 성공_로또생성_금액의수만큼() {
        // given
        int amount = 5000;

        // when
        List<Lotto> lottos = lottoNumberGenerator.generate(amount);

        // then
        assertThat(lottos).hasSize(5);
    }
}
