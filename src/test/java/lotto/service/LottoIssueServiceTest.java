package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoIssue;
import lotto.strategy.AutoIssueStrategy;
import lotto.strategy.IssueStrategy;
import lotto.support.ManualIssueStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssueServiceTest {

    @Test
    void 자동_발행_로또_성공() {
        //given
        IssueStrategy issueStrategy = new AutoIssueStrategy();
        LottoIssueService lottoIssueService = new LottoIssueService(issueStrategy);

        //when
        LottoIssue lottoIssue = lottoIssueService.issue(8);

        //then
        assertThat(lottoIssue.getLottos()).hasSize(8);
    }

    @Test
    void 수동_발행_로또_성공() {
        //given
        List<Integer> numbers1 = List.of(10, 11, 12, 13, 14, 15);
        List<Integer> numbers2 = List.of(20, 21, 22, 23, 24, 25);
        List<Integer> numbers3 = List.of(30, 31, 32, 33, 34, 35);
        List<Integer> numbers4 = List.of(40, 41, 42, 43, 44, 45);

        IssueStrategy issueStrategy = ManualIssueStrategy.ofList(
                numbers1,
                numbers2,
                numbers3,
                numbers4
        );
        LottoIssueService lottoIssueService = new LottoIssueService(issueStrategy);

        //when
        LottoIssue lottoIssue = lottoIssueService.issue(8);

        //then
        assertThat(lottoIssue.getLottos()).hasSize(8);
        assertThat(lottoIssue.getLottos()).extracting(Lotto::getNumbers)
                .containsExactly(numbers1, numbers2, numbers3, numbers4, numbers1, numbers2, numbers3, numbers4);
    }



}