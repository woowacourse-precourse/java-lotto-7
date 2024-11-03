package machine.winnerdrawer;

import static lotto.machine.winnerdrawer.LotteryRank.FIFTH;
import static lotto.machine.winnerdrawer.LotteryRank.FIRST;
import static lotto.machine.winnerdrawer.LotteryRank.FOURTH;
import static lotto.machine.winnerdrawer.LotteryRank.SECOND;
import static lotto.machine.winnerdrawer.LotteryRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.machine.winnerdrawer.LotteryDrawer;
import lotto.machine.winnerdrawer.LotteryRank;
import lotto.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryDrawerTest {

    private final Set<Integer> winningNumber = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 purchaseLotto 리스트가 null이거나 빈 리스트이면 예외가 발생한다.")
    void validatePurchaseLottoList() {
        // given
        int bonusNumber = 7;
        List<Lotto> purchaseLotto1 = null;
        List<Lotto> purchaseLotto2 = new ArrayList<>(); // 빈 리스트

        // when, then
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto1, winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매한 로또가 없습니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto2, winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매한 로또가 없습니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 winningNumber set이 null이거나 빈 set이면 예외가 발생한다.")
    void validateWinningNumberSet() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> purchaseLotto = List.of(lotto);
        Set<Integer> winningNumber1 = null;
        Set<Integer> winningNumber2 = new HashSet<>(); // 빈 set

        // when, then
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 없습니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 없습니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 winningNumber가 6개가 아니면 예외가 발생한다.")
    void validateWinningNumberCount() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> purchaseLotto = List.of(lotto);
        Set<Integer> winningNumber1 = new HashSet<>(Set.of(1, 2, 3, 4, 5)); // 당첨 숫자가 6개보다 적은 경우
        Set<Integer> winningNumber2 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7)); // 당첨 숫자가 6개보다 많은 경우

        // when, then
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야합니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야합니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 winningNumber가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    void validateWinningNumberRange() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> purchaseLotto = List.of(lotto);
        Set<Integer> winningNumber1 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 0));
        Set<Integer> winningNumber2 = new HashSet<>(Set.of(1, 2, 3, 4, 5, 46));

        // when, then
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 bonusNumber가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    void validateBonusNumberRange() {
        // given
        int bonusNumber1 = 0;
        int bonusNumber2 = 46;
        int bonusNumber3 = -7;

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> purchaseLotto = List.of(lotto);

        // when, then
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber, bonusNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber, bonusNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> new LotteryDrawer(purchaseLotto, winningNumber, bonusNumber3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("LotteryDrawer 객체 생성 시 drawResult를 초기화해야한다.")
    void testInitializeDrawResult() {
        // given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = List.of(lotto);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4);
        LotteryDrawer lotteryDrawer = new LotteryDrawer(lottos, winningNumber, bonusNumber);

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