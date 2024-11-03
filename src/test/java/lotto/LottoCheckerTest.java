package lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottoCheckerTest {

    private LottoChecker checker;

    @BeforeEach
    void setUp() {
        checker = new LottoChecker();
    }

    @Test
    void getMatchCount_correctMatch() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 7, 8, 9);
        int matchCount = checker.getMatchCount(lottoNumbers, winningNumbers);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void printResults_validOutput() {
        // 이 테스트는 출력 값을 테스트하므로, 통합 테스트 또는 시스템 출력 캡처가 필요할 수 있음
    }

    @Test
    void printProfitRate_correctProfit() {
        // 테스트에서는 가상의 Lotto 객체 리스트를 사용하여 결과를 검증
        // 필요 시 Mocking 도구를 사용하여 구현
    }
}