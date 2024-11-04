package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class ResultTest {
    private Lotto winningLotto;
    private int bonus;
    private List<Lotto> userTickets;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = 7;
        userTickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11))
        );
    }

    @Test
    void 사용자_복궈번호와_당첨번호를_비교해서_결과를_생성한다() {
        Map<String, Integer> hitResult = new Result(winningLotto, bonus, userTickets).getHitResult();

        assertThat(Arrays.stream(Ranking.values()).allMatch(rank -> hitResult.get(rank.name()) == 1))
                .isTrue();
    }

    @Test
    void 결과를_생성한다() {
        Result result = new Result(winningLotto, bonus, userTickets);

        assertThat(result.getResult())
                .isEqualTo(
                        """
                                3개 일치 (5,000원) - 1개
                                4개 일치 (50,000원) - 1개
                                5개 일치 (1,500,000원) - 1개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                                6개 일치 (2,000,000,000원) - 1개"""
                );
    }
}
