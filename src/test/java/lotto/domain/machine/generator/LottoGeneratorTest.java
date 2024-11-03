package lotto.domain.machine.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("숫자 정보가 주어지면, 로또가 발급된다.")
    void givenNumberGeneratorAndCreatedLottoGenerator_whenIssueLotto_thenReturnExpectedResult() {
        LottoGenerator lottoGenerator = new LottoGenerator(() -> List.of(1, 2, 3, 4, 5, 6));

        Lotto result = lottoGenerator.issueLotto();

        assertThat(result.match(Lotto.from(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

}