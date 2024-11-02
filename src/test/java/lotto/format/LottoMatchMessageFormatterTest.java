package lotto.format;

import lotto.domain.LottoMatch;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchMessageFormatterTest {

    @Test
    void 당첨_통계_출력() {
        //given
        LottoMatch lottoMatch = new LottoMatch(List.of(SECOND, THIRD, FOURTH, FIFTH, FIFTH, NO_RANK));

        //when
        String format = new LottoMatchMessageFormatter().format(lottoMatch);

        //then
        assertThat(format).isEqualTo(answer());
    }

    static String answer() {
        return """
                3개 일치 (5,000원) - 2개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 0개""";
    }
}