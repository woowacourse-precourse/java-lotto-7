package lotto.domain;

import lotto.strategy.IssueStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueLottoTest {

    @Test
    void 사용자_로또_정보_생성() {
        //given
        long issueCount = 10;
        IssueStrategy issueStrategy = () -> List.of(1, 2, 3, 4, 5, 6);

        //when
        IssueLotto issueLotto = new IssueLotto(issueCount, issueStrategy);

        //then
        assertThat(issueLotto.getLottos()).hasSize(10);
    }
}
