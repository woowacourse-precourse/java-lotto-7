package lotto;

import static lotto.LottoGenerator.generateLottos;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("입력한 횟수 만큼 로또를 생성한다.")
    @Test
    void 입력한_횟수_만큼_로또를_생성한다() {
        int attemptCount = 5;
        List<Lotto> lottos = generateLottos(5);
        assertThat(lottos).hasSize(attemptCount);
    }
}
