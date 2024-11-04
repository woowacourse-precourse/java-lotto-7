package lotto.format;

import lotto.domain.LottoIssue;
import lotto.service.LottoIssueService;
import lotto.strategy.IssueStrategy;
import lotto.support.ManualIssueStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssueMessageFormatterTest {

    LottoIssueService lottoIssueService;

    @BeforeEach
    void setUp() {
        IssueStrategy issueStrategy = ManualIssueStrategy.ofList(
                List.of(10, 11, 12, 13, 14, 15),
                List.of(20, 21, 22, 23, 24, 25),
                List.of(30, 31, 32, 33, 34, 35),
                List.of(40, 41, 42, 43, 44, 45)
        );

        lottoIssueService = new LottoIssueService(issueStrategy);
    }

    @Test
    void 발행한_로또_번호_출력() {
        //given
        LottoIssue lottoIssue = lottoIssueService.issue(8);

        //when
        String format = new LottoIssueMessageFormatter().format(lottoIssue);

        //then
        assertThat(format).isEqualTo(answer());
    }

    static String answer() {
        return """
                [10, 11, 12, 13, 14, 15]
                [20, 21, 22, 23, 24, 25]
                [30, 31, 32, 33, 34, 35]
                [40, 41, 42, 43, 44, 45]
                [10, 11, 12, 13, 14, 15]
                [20, 21, 22, 23, 24, 25]
                [30, 31, 32, 33, 34, 35]
                [40, 41, 42, 43, 44, 45]""";
    }
}