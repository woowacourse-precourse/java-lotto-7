package lotto;

import lotto.Domain.LottoResult;
import lotto.Service.LottoResultService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultServiceTest {
    @Test
    public void getMatchingCount_테스트_1() {
        assertSimpleTest(() -> {
            assertThat(LottoResultService.getMatchingCount(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(1, 2, 3, 7, 8, 9))
            ).isEqualTo(3);

        });
    }

    @Test
    public void getMatchingCount_테스트_2() {
        assertSimpleTest(() -> {
            assertThat(LottoResultService.getMatchingCount(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(1, 2, 3, 4, 5, 6))
            ).isEqualTo(6);

        });
    }
}
