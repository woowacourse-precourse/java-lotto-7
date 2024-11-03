package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성기를 생성할 수 있다.")
    void should_CreateLottoGenerator_When_GivenGenerator() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        // when
        LottoGenerator lottoGenerator = new LottoGenerator(numberGenerator);
        // then
        Assertions.assertThat(lottoGenerator).isNotNull();
    }

    @Test
    @DisplayName("로또를 생성할 수 있다.")
    void should_GenerateLotto() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(numberGenerator);
        // when
        List<Lotto> lottos = lottoGenerator.generate(1);
        // then
        Assertions.assertThat(lottos.size()).isEqualTo(1);
    }
}