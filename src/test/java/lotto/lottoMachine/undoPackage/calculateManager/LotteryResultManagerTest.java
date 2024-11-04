package lotto.lottoMachine.undoPackage.calculateManager;

import lotto.Lotties;
import lotto.lottoMachine.calculateManager.LotteryResultManager;
import lotto.lottoMachine.lottoTotalResult.LottoTotalResultManager;
import lotto.lottoMachine.utils.LottoResultStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultManagerTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;

    private Lotties lotties;
    private LottoTotalResultManager lottoTotalResultManager;
    private LotteryResultManager lotteryResultManager;

    @BeforeEach
    void setUp() {
        // 로또 티켓을 생성하여 초기화
        lotties = new Lotties();
        lottoTotalResultManager = new LottoTotalResultManager();
        lotteryResultManager = new LotteryResultManager(WINNING_NUMBERS, BONUS_NUMBER, lottoTotalResultManager, lotties);
    }

    @DisplayName("로또 당첨 결과가 올바르게 관리되고 저장되는지 테스트")
    @Test
    void 로또_당첨_결과가_올바르게_관리되고_저장되는지_테스트() {
        // Given: 다양한 케이스의 로또 티켓 추가
        lotties.addLotto(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치
        lotties.addLotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 + 보너스
        lotties.addLotto(List.of(1, 2, 3, 4, 5, 8)); // 5개 일치
        lotties.addLotto(List.of(1, 2, 3, 4, 10, 11)); // 4개 일치

        // When
        lotteryResultManager.manageLotteryResults();

        // Then: LottoTotalResultManager에 저장된 결과가 예상과 일치하는지 확인
        Map<LottoResultStructure, Integer> results = lottoTotalResultManager.getResults();

        assertThat(results.get(LottoResultStructure.FIRST)).isEqualTo(1);     // 6개 일치
        assertThat(results.get(LottoResultStructure.SECOND)).isEqualTo(1);    // 5개 + 보너스
        assertThat(results.get(LottoResultStructure.THIRD)).isEqualTo(1);     // 5개 일치
        assertThat(results.get(LottoResultStructure.FOURTH)).isEqualTo(1);    // 4개 일치
        assertThat(results.get(LottoResultStructure.FIFTH)).isEqualTo(0);     // 3개 일치 없음
    }

    @DisplayName("로또 티켓이 없을 때 결과가 모두 0인지 테스트")
    @Test
    void 로또_티켓이_없을_때_결과가_모두_0인지_테스트() {
        // When
        lotteryResultManager.manageLotteryResults();

        // Then: 결과가 모두 0인지 확인
        Map<LottoResultStructure, Integer> results = lottoTotalResultManager.getResults();;

        assertThat(results.values()).allMatch(count -> count == 0);
    }
}
