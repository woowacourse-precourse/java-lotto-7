package lotto.format;

import lotto.domain.IssueLotto;
import lotto.strategy.IssueStrategy;
import lotto.support.ManualIssueStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IssueLottoMessageFormatterTest {

    @Test
    void 발행한_로또_번호_출력() {
        //given
        IssueStrategy issueStrategy = ManualIssueStrategy.ofList(
                List.of(10, 11, 12, 13, 14, 15),
                List.of(20, 21, 22, 23, 24, 25),
                List.of(30, 31, 32, 33, 34, 35),
                List.of(40, 41, 42, 43, 44, 45)
        );
        IssueLotto issueLotto = new IssueLotto(8, issueStrategy);

        //when
        String format = new IssueLottoMessageFormatter().format(issueLotto);

        //then
        assertThat(format).isEqualTo(answer());
    }

    static String answer() {
        return "[10, 11, 12, 13, 14, 15]\n" +
                "[20, 21, 22, 23, 24, 25]\n" +
                "[30, 31, 32, 33, 34, 35]\n" +
                "[40, 41, 42, 43, 44, 45]\n" +
                "[10, 11, 12, 13, 14, 15]\n" +
                "[20, 21, 22, 23, 24, 25]\n" +
                "[30, 31, 32, 33, 34, 35]\n" +
                "[40, 41, 42, 43, 44, 45]";
    }
}