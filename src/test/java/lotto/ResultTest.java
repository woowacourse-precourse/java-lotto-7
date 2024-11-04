package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class ResultTest {
    @Test
    void 사용자_복궈번호와_당첨번호를_비교해서_결과를_생성한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        List<Lotto> userTickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11))
        );

        Map<String, Integer> hitResult = new Result(winningLotto, bonus, userTickets).getHitResult();

        assertThat(Arrays.stream(Ranking.values()).allMatch(rank -> hitResult.get(rank.name()) == 1))
                .isTrue();
    }
}
