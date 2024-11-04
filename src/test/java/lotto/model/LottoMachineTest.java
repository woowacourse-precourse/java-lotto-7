package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {
    private LottoMachine lottoMachine;
    private Map<Prize, Integer> prizeCount;

    @BeforeEach
    public void setUp() {
        List<Lotto> fixedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),   // 5개 일치 (보너스 번호 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),   // 5개 일치
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4개 일치
                new Lotto(List.of(1, 2, 3, 15, 20, 25)) // 3개 일치
        );
        lottoMachine = new LottoMachine(fixedLottos);

        prizeCount = new EnumMap<>(Prize.class);
        prizeCount.put(Prize.SIX, 1);
        prizeCount.put(Prize.BONUS, 1);
        prizeCount.put(Prize.FIVE, 1);
        prizeCount.put(Prize.FOUR, 1);
        prizeCount.put(Prize.THREE, 1);
        prizeCount.put(Prize.NONE, 0);
    }

    @DisplayName("금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액만큼 로또가 발행되는지 확인한다.")
    @Test
    void 로또_발행수_확인() {
        LottoMachine lottoMachine = new LottoMachine(8000);
        assertThat(lottoMachine.getLottos()).hasSize(8);
    }

    @DisplayName("로또 리스트가 문자열로 표시되는지 확인한다.")
    @Test
    void 로또_리스트_문자열_표시() {
        List<String> lottos = lottoMachine.displayLottos();

        List<String> expected = List.of(
                "[1, 2, 3, 4, 5, 6]",
                "[1, 2, 3, 4, 5, 7]",
                "[1, 2, 3, 4, 5, 8]",
                "[1, 2, 3, 4, 10, 11]",
                "[1, 2, 3, 15, 20, 25]"
        );

        assertThat(lottos).isEqualTo(expected);
    }

    @DisplayName("당첨된 내역을 계산한다.")
    @Test
    void 당첨_내역_계산() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);

        Map<Prize, Integer> prizeCountResult = lottoMachine.calculateWinningCounts(winningNumber);

        assertThat(prizeCountResult).isEqualTo(prizeCount);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률_계산() {
        double returnRate = lottoMachine.calculateReturnRate(prizeCount);

        assertThat(returnRate).isEqualTo(40_631_100.0);
    }
}
