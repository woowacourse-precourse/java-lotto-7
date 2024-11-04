package lotto.model;

import static lotto.model.LotteryDrawer.validateBonusNumber;
import static lotto.model.LotteryDrawer.validateWinningNumbers;
import static lotto.model.LotteryRank.FIFTH;
import static lotto.model.LotteryRank.FIRST;
import static lotto.model.LotteryRank.FOURTH;
import static lotto.model.LotteryRank.SECOND;
import static lotto.model.LotteryRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawerTest {

    private final Set<Integer> winningNumber = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("winningNumber set이 null이거나 빈 set이면 예외가 발생한다.")
    void validateWinningNumberSet() {
        // given
        Set<Integer> winningNumber1 = null; // 빈 set
        Set<Integer> winningNumber2 = new HashSet<>(); // 빈 set

        // when, then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 없습니다.");
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호가 없습니다.");
    }

    @Test
    @DisplayName("winningNumber가 6개가 아니면 예외가 발생한다.")
    void validateWinningNumberCount() {
        // given
        Set<Integer> winningNumber1 = new HashSet<>(Set.of(1, 2, 3, 4, 5)); // 당첨 숫자가 6개보다 적은 경우
        Set<Integer> winningNumber2 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7)); // 당첨 숫자가 6개보다 많은 경우

        // when, then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야합니다.");
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야합니다.");
    }

    @Test
    @DisplayName("winningNumber가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    void validateWinningNumberRange() {
        // given
        Set<Integer> winningNumber1 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 0));
        Set<Integer> winningNumber2 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 46));

        // when, then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> validateWinningNumbers(winningNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("bonusNumber가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    void validateBonusNumberRange() {
        // given
        int bonusNumber1 = 0;
        int bonusNumber2 = 46;
        int bonusNumber3 = -7;

        // when, then
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 drawResult를 초기화해야한다.")
    void testInitializeDrawResult() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lotteries = List.of(lotto);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.containsKey(FIRST)).isTrue();
        assertThat(drawResult.containsKey(SECOND)).isTrue();
        assertThat(drawResult.containsKey(THIRD)).isTrue();
        assertThat(drawResult.containsKey(FOURTH)).isTrue();
        assertThat(drawResult.containsKey(FIFTH)).isTrue();

        assertThat(drawResult.get(FIRST)).isEqualTo(0);
        assertThat(drawResult.get(SECOND)).isEqualTo(0);
        assertThat(drawResult.get(THIRD)).isEqualTo(0);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("6개의 숫자가 모두 일치하면 1등에 당첨한다.")
    void testWhenFirstPrize() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        List<Lotto> lotteries = List.of(lotto);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(0);
        assertThat(drawResult.get(THIRD)).isEqualTo(0);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 5개와 보너스 번호가 일치하면 2등에 당첨한다.")
    void testWhenSecondPrize() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(0);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 5개가 일치하고 보너스 번호가 일치하지 않으면 3등에 당첨한다.")
    void testWhenThirdPrize() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 4개가 일치하면 4등에 당첨한다.")
    void testWhenFourthPrize() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 3개가 일치하면 5등에 당첨한다.")
    void testWhenFifthPrize() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하는 숫자가 2개 이하이면 미당첨이다.")
    void testWhenNoHit() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));  // 일치하는 숫자 2개
        Lotto lotto2 = new Lotto(Arrays.asList(1, 8, 9, 10, 11, 12)); // 일치하는 숫자 1개
        Lotto lotto3 = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)); // 일치하는 숫자 0개
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(0);
        assertThat(drawResult.get(SECOND)).isEqualTo(0);
        assertThat(drawResult.get(THIRD)).isEqualTo(0);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("1등에 당첨한 로또가 여러 개일 수 있다.")
    void testWhenDuplicatedFirstRank() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(2);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등에 당첨한 로또가 여러 개일 수 있다.")
    void testWhenDuplicatedSecondRank() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(2);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등에 당첨한 로또가 여러 개일 수 있다.")
    void testWhenDuplicatedThirdRank() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)); // 3등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(2);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등에 당첨한 로또가 여러 개일 수 있다.")
    void testWhenDuplicatedFourthRank() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)); // 4등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(2);
        assertThat(drawResult.get(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("5등에 당첨한 로또가 여러 개일 수 있다.")
    void testWhenDuplicatedFifthRank() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등 당첨
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 당첨
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등 당첨
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)); // 4등 당첨
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)); // 5등 당첨
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)); // 5등 당첨
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(1);
        assertThat(drawResult.get(SECOND)).isEqualTo(1);
        assertThat(drawResult.get(THIRD)).isEqualTo(1);
        assertThat(drawResult.get(FOURTH)).isEqualTo(1);
        assertThat(drawResult.get(FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("구매한 로또가 모두 당첨되지 않으면 당첨 결과의 등수별 개수가 모두 0이어야한다.")
    void testWhenAllLottoFailToWin() {
        // given
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 13));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 14));
        Lotto lotto4 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 15));
        List<Lotto> lotteries = Arrays.asList(lotto1, lotto2, lotto3, lotto4);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winningNumber, bonusNumber);

        // when
        lotteryDrawer.draw();
        Map<LotteryRank, Integer> drawResult = lotteryDrawer.getDrawResult();

        // then
        assertThat(drawResult.size()).isEqualTo(5);
        assertThat(drawResult.get(FIRST)).isEqualTo(0);
        assertThat(drawResult.get(SECOND)).isEqualTo(0);
        assertThat(drawResult.get(THIRD)).isEqualTo(0);
        assertThat(drawResult.get(FOURTH)).isEqualTo(0);
        assertThat(drawResult.get(FIFTH)).isEqualTo(0);
    }
}