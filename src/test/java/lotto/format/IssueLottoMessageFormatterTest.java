package lotto.format;

import lotto.domain.IssueLotto;
import lotto.strategy.AutoIssueStrategy;
import lotto.strategy.IssueStrategy;
import org.junit.jupiter.api.Test;

class IssueLottoMessageFormatterTest {

    @Test
    void 발행한_로또_번호_출력() {
        //given
        IssueStrategy issueStrategy = AutoIssueStrategy.getInstance();
        IssueLotto issueLotto = new IssueLotto(8, issueStrategy);

        //when
        String format = new IssueLottoMessageFormatter().format(issueLotto);

        //then
        System.out.println(format);
    }
}