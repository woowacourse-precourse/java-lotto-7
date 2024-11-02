package lotto.domain.lottomachine;

import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 원하는_수량만큼_로또를_생성할_수_있다() {
        //given
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
        //when
        PurchasedLottos purchasedLottos = lottoMachine.issueTickets(new ManualLottoGenerator(lottos), 3);
        //then
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(3);
        assertThat(purchasedLottos.getLottos().getFirst().getNumbers()).containsExactlyElementsOf(List.of(1, 2, 3, 4, 5, 6));
        assertThat(purchasedLottos.getLottos().get(1).getNumbers()).containsExactlyElementsOf(List.of(7, 8, 9, 10, 11, 12));
        assertThat(purchasedLottos.getLottos().get(2).getNumbers()).containsExactlyElementsOf(List.of(13, 14, 15, 16, 17, 18));
    }

    @Test
    void 구매한_수량만큼_로또가_생성되지_않으면_예외가_발생한다() {
        //given
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        //when
        //then
        assertThatThrownBy(() -> lottoMachine.issueTickets(new ManualLottoGenerator(lottos), 2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 더이상 존재하는 로또가 없습니다.");
    }
}