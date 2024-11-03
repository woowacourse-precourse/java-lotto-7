package lotto.service;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("구입 금액에 맞게 로또를 생성한다")
    void generateLottosWithPrice() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        Lottos lottos = generator.generateLottos(5000);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("커스텀 번호 생성기로 로또를 생성한다")
    void generateLottosWithCustomNumberGenerator() {
        // given
        List<Integer> fixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGenerator generator = new LottoGenerator(() -> fixedNumbers);

        // when
        Lottos lottos = generator.generateLottos(1000);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(1);
        assertThat(lottos.toString()).contains(fixedNumbers.toString());
    }
}