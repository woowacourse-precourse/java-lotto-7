package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LotteryProcess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryProcessTest {

    @DisplayName("기능 테스트")
    @Test
    void 기능_테스트() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusBallNumber = 7;
        List<List<Integer>> tickets = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), //1등
                Arrays.asList(1, 2, 3, 7, 8, 9), //5등
                Arrays.asList(1, 2, 3, 4, 9, 11), //4등
                Arrays.asList(1, 2, 3, 4, 5, 7)); //2등
        LotteryProcess lotteryProcess = new LotteryProcess(numbers, bonusBallNumber, tickets);
        // When
        List<Integer> rankingCount = lotteryProcess.countMatchNumbers(); // 등수의 갯수를 리스트로 변환
        // Then
        List<Integer> expects = Arrays.asList(1, 1, 0, 1, 1);
        assertThat(rankingCount).isEqualTo(expects);
    }
}
