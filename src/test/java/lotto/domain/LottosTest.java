package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    Lottos lottos;
    List<Lotto> args;

    @BeforeEach
    void setUp() {
        args = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(5, 6, 7, 8, 9, 10))
        );
        lottos = new Lottos(args);
    }

    @Test
    @DisplayName("갯수 검증")
    void getCountVerify() {
        assertThat(lottos.getCount()).isEqualTo(args.size());
    }

    @Test
    @DisplayName("숫자 맞춰보기")
    void matchNumbers() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);
        Result result = lottos.matchNumbers(winningLotto);
        assertThat(result).isNotNull();
        String prettyString = result.toPrettyString();
        assertThat(prettyString).contains("6개 일치 (2,000,000,000원) - 1개");
        assertThat(prettyString).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
        assertThat(prettyString).contains("5개 일치 (1,500,000원) - 0개");
        assertThat(prettyString).contains("4개 일치 (50,000원) - 1개");
        assertThat(prettyString).contains("3개 일치 (5,000원) - 1개");
    }
}
