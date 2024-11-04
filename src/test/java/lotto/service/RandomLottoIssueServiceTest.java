package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomLottoIssueServiceTest {

    @DisplayName("랜덤으로 번호가 부여되는 로또 1개를 생성한다.")
    @Test
    void randomLottoIssue() {
        // given
        RandomLottoIssueService service = new RandomLottoIssueService();
        // when & then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(service.issue(null).toString())
                            .isNotNull()
                            .isEqualTo("[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("랜덤으로 번호가 부여되는 로또 n개를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void randomLottiesIssue(int lottoCnt) {
        // given
        RandomLottoIssueService service = new RandomLottoIssueService();
        // when & then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(service.issue(null, lottoCnt).size())
                            .isEqualTo(3);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6));
    }
}