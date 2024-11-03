package lotto.view.output.message;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.rank.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class RankMessageGeneratorTest {

    RankMessageGenerator rankMessageGenerator = new RankMessageGenerator();

    @CsvSource(textBlock = """
            FIFTH,0,'3개 일치 (5,000원) - 0개'
            FOURTH,1,'4개 일치 (50,000원) - 1개'
            THIRD,2,'5개 일치 (1,500,000원) - 2개'
            SECOND,3,'5개 일치, 보너스 볼 일치 (30,000,000원) - 3개'
            FIRST,4,'6개 일치 (2,000,000,000원) - 4개'
            """)
    @ParameterizedTest
    void 로또_순위_메세지를_생성할_수_있다(LottoRank lottoRank, int matchingCount, String expectedMessage) {
        // when
        String message = rankMessageGenerator.getMessage(lottoRank, matchingCount);

        // then
        assertThat(message).isEqualTo(expectedMessage);
    }

}
