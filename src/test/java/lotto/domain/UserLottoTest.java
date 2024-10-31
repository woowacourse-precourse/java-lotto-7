package lotto.domain;

import lotto.strategy.IssueStrategy;
import lotto.support.ManualIssueStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {

    @Test
    void 사용자_로또_정보_생성() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(10_000L);
        IssueStrategy issueStrategy = ManualIssueStrategy.ofList(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(11, 2, 3, 4, 5, 6),
                List.of(11, 12, 3, 4, 5, 6),
                List.of(11, 12, 13, 4, 5, 6),
                List.of(11, 12, 13, 14, 5, 6),
                List.of(11, 12, 13, 14, 15, 6),
                List.of(11, 12, 13, 14, 15, 16)
        );

        //when
        UserLotto userLotto = new UserLotto(lottoPurchase, issueStrategy);

        //then
        assertThat(userLotto.getPurchase().getMoney()).isEqualTo(10_000L);
        assertThat(userLotto.getPurchase().getCount()).isEqualTo(10);
        assertThat(userLotto.getLottos()).hasSize(10);
    }
}
