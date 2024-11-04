package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto.RankDto;
import lotto.view.formatter.OutputFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputFormatterTest {

    @Test
    @DisplayName("로또 번호에 대해 의도한 형식대로 포매팅된다.")
    void formatLottoNumbersCorrectly() {
        // given
        List<LottoDto> lottoDtos = List.of(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6))
        );

        // when
        List<String> result = OutputFormatter.formatLottoNumbers(lottoDtos);

        // then
        assertThat(result).isEqualTo(List.of("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    @DisplayName("순위 개수에 대해 의도한 형식대로 포매팅된다.")
    void formatRankCountCorrectly() {
        // given
        List<RankDto> rankDtos = List.of(
                new RankDto("3개 일치 (5,000원)", 1)
        );

        // when
        List<String> result = OutputFormatter.formatRankCount(rankDtos);

        // then
        assertThat(result).isEqualTo(List.of("3개 일치 (5,000원) - 1개"));
    }

    @Test
    @DisplayName("수익률에 대해 의도한 형식대로 포매팅된다.")
    void formatProfitRateCorrectly() {
        // given
        double profitRate = 36.6777777;

        // when
        String result = OutputFormatter.formatProfitRate(profitRate);

        // then
        assertThat(result).isEqualTo("총 수익률은 36.7%입니다.");
    }

    @Test
    @DisplayName("구매한 로또 개수에 대해 의도한 형식대로 포매팅된다.")
    void formatSizeOfLottoCorrectly() {
        // given
        int sizeOfLotto = 3;

        // when
        String result = OutputFormatter.formatSizeOfLotto(sizeOfLotto);

        // then
        assertThat(result).isEqualTo("3개를 구매했습니다.");
    }

}
