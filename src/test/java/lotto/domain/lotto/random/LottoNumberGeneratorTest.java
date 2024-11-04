package lotto.domain.lotto.random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoNumberGeneratorTest {

    private final CreateRandomNumbers createRandomNumbers = new LottoNumberGenerator();

    @Test
    void 로또_번호_생성_개수와_범위를_확인한다() {
        // given
        List<Integer> lottoNumber = createRandomNumbers.getRandomNumbers();

        // then
        assertThat(lottoNumber.size()).isEqualTo(6);
        assertTrue(lottoNumber.stream()
                .allMatch(n -> n >= 1 && n <= 45));
    }
}
