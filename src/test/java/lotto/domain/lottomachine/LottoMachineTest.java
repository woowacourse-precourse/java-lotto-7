package lotto.domain.lottomachine;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbers;
import lotto.domain.constant.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        List<List<Integer>> lottos = createLottos();
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(lottos);
        lottoMachine = new LottoMachine(manualLottoGenerator);
    }

    @Test
    void 원하는_수량만큼_로또를_생성할_수_있다() {
        //given
        //when
        PurchasedLottos purchasedLottos = lottoMachine.issueTickets(3);
        //then
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(3);
        assertThat(purchasedLottos.getLottos().getFirst().getNumbers()).containsExactlyElementsOf(List.of(1, 2, 3, 4, 5, 6));
        assertThat(purchasedLottos.getLottos().get(1).getNumbers()).containsExactlyElementsOf(List.of(7, 8, 9, 10, 11, 12));
        assertThat(purchasedLottos.getLottos().get(2).getNumbers()).containsExactlyElementsOf(List.of(13, 14, 15, 16, 17, 18));
    }

    @Test
    void 구매한_수량만큼_로또가_생성되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoMachine.issueTickets(4))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 더이상 존재하는 로또가 없습니다.");
    }

    @Test
    void 로또를_구매하면_당첨_통계가_나온다() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(11, 12, 13, 14, 15, 16)), //NONE
                new Lotto(List.of(10, 20, 30, 40, 14, 45)), //NONE
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), //FIRST
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(List.of(1, 2, 3, 4, 5, 30)), //THIRD
                new Lotto(List.of(1, 2, 3, 4, 14, 45)), //FOURTH
                new Lotto(List.of(10, 2, 3, 4, 14, 45)), //FIFTH
                new Lotto(List.of(1, 20, 3, 4, 14, 45)) //FIFTH
        );
        PurchasedLottos purchasedLottos = PurchasedLottos.from(lottos);
        WinningNumbers winningNumbers = WinningNumbers.from(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        //when
        EnumMap<Ranking, Integer> statistics = lottoMachine.draw(purchasedLottos, winningNumbers);
        //then
        assertThat(statistics.get(Ranking.FIRST)).isEqualTo(1);
        assertThat(statistics.get(Ranking.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Ranking.THIRD)).isEqualTo(1);
        assertThat(statistics.get(Ranking.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Ranking.FIFTH)).isEqualTo(2);
        assertThat(statistics.get(Ranking.NONE)).isEqualTo(2);
    }

    private List<List<Integer>> createLottos() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
    }
}