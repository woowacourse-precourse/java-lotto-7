package lotto.service.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;
    private static final Integer NUMBER_COUNT = 6;

    @DisplayName("로또 발행 결과를 검증합니다.")
    @Test
    void 로또_발행_결과를_검증합니다() {
        int lottoCount = 3;

        LottoGenerator lottoGenerator = LottoGenerator.create(lottoCount);

        List<Lotto> lottoList = lottoGenerator.getLottoTicket();
        List<Integer> lotto = lottoList.getFirst().getNumbers();

        assertThat(lotto.size()).isEqualTo(NUMBER_COUNT);
        assertThat(
                lotto.stream().allMatch(number -> number >= MIN_NUMBER_RANGE && number <= MAX_NUMBER_RANGE)).isTrue();
    }
}