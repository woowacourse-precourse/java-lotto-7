package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static List<Integer> testWinningNums;

    @BeforeAll
    static void setUp() {
        testWinningNums =  Stream.of(2, 13, 20, 23, 31, 42)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    void 일등_당첨() {
        Lotto lotto = new Lotto(
                Stream.of(2, 13, 20, 23, 31, 42)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.FIRST);
    }

    @Test
    void 이등_당첨() {
        Lotto lotto = new Lotto(
                Stream.of(5, 13, 20, 23, 31, 42)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.SECOND);
    }

    @Test
    void 삼등_당첨() {
        Lotto lotto = new Lotto(
                Stream.of(2, 16, 20, 23, 31, 42)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.THIRD);
    }

    @Test
    void 사등_당첨() {
        Lotto lotto = new Lotto(
                Stream.of(5, 13, 20, 26, 31, 42)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.FOURTH);
    }

    @Test
    void 오등_당첨() {
        Lotto lotto = new Lotto(
                Stream.of(2, 10, 21, 23, 31, 43)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 꽝() {
        Lotto lotto = new Lotto(
                Stream.of(9, 16, 22, 23, 35, 45)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        lotto.getResult(testWinningNums, 5);
        assertThat(lotto.getPrize()).isEqualTo(Prize.LOSE);
    }
}
