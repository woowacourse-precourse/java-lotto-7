package lotto.model.draw;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoTicket;
import lotto.model.strategy.CustomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DrawResultTest {

    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;
    private LottoTicket lottoTicket;
    private WinningLottoTicket winningLottoTicket;
    private DrawResult drawResult;

    @BeforeEach
    void beforeEach() {
        lottos = new ArrayList<>();
        lottoGenerator = new LottoGenerator();
        lottoTicket = generateLottoTicket();
        winningLottoTicket = generateWinningLottoTicket();
        drawResult = DrawResult.of(winningLottoTicket, lottoTicket);
        drawResult.generateDrawResult();
    }

    private LottoTicket generateLottoTicket() {
        List<String> inputLottos = List.of(
                "1,2,3,4,5,6",
                "1,2,3,4,5,16",
                "1,2,3,4,15,16",
                "1,2,3,14,25,36",
                "11,12,13,14,15,16"
        );

        for (String inputLotto : inputLottos) {
            Lotto lotto = lottoGenerator.generateSingleLotto(CustomStrategy.of(inputLotto));
            lottos.add(lotto);
        }

        return LottoTicket.of(lottos);
    }

    private WinningLottoTicket generateWinningLottoTicket() {
            Lotto lotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,2,3,4,5,6"));
            BonusNumber bonusNumber = BonusNumber.from("16");
        return WinningLottoTicket.of(lotto, bonusNumber);
    }

    @Test
    void 로또_추첨_결과가_생성됩니다() {
        Map<Prize, Integer> result = drawResult.getDrawResult();

        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.get(Prize.THIRD)).isEqualTo(0);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(result.get(Prize.BLANK)).isEqualTo(1);
    }

    @Test
    void 총_당첨_상금을_계산합니다() {
        assertThat(drawResult.calculateTotalPrizeMoney()).isEqualTo(2030055000);
    }

}