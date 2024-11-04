package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private LottoController lottoController;

    @BeforeEach
    void setup() {
        lottoController = new LottoController("test");
    }

    @Nested
    class 로또_발행 {
        @Test
        void 구입한_만큼_로또를_발행한다() {
            //given
            int count = 3;
            //when
            lottoController.issueLotto(count);
            //then,
            assertThat(lottoController.getLottos().size()).isEqualTo(count);
        }

        @RepeatedTest(5)
        void 로또번호에_중복은_없어야_한다() {
            //when
            lottoController.issueLotto(5);
            //then
            for (Lotto lotto : lottoController.getLottos()) {
                assertThat(lotto.getNumbers().size()).isEqualTo(new HashSet<Integer>(lotto.getNumbers()).size());
            }
        }
    }

    @Test
    void 로또번호가_몇등인지_확인한다() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoController.updateWinningList(winningLotto);

        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int rank = lottoController.getRanking(testLotto);

        // then
        assertThat(rank).isEqualTo(2);
    }

    @Test
    void 수익률을_계산한다() {
        // given
        int purchaseCount = 5;
        lottoController.issueLotto(purchaseCount);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        lottoController.updateWinningList(winningLotto);

        // when
        double winningRate = lottoController.calculateWinningRate();

        // then
        assertThat(winningRate).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 당첨정보를_담고있는_map을_생성한다() {
        assertThat(lottoController.getWinningList().size()).isEqualTo(6);
    }
}
