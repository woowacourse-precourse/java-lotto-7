package lotto.domain.machine.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.ui.dto.LottoNumbersResponse;
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

    @Test
    @DisplayName("숫자 정보가 주어지면, 로또가 정렬된 로또 번호가 발급된다.")
    void givenNumberGeneratorAndCreatedLottoGenerator_whenIssueLotto_thenReturnSortedLottoNumber() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator(() -> List.of(6, 5, 4, 3, 2, 1));

        // when
        Lotto result = lottoGenerator.issueLotto();

        // then
        LottoNumbersResponse response = result.toResponse();
        assertThat(response.getNumbers().equals(List.of(1, 2, 3, 4, 5, 6))).isTrue();
    }

}