package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.ResultLotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameServiceTest {
    private final LottoGameService lottoGameService;

    public LottoGameServiceTest() {
        this.lottoGameService = new LottoGameService();
    }

    @Test
    void 로또_당첨_로직_확인() {
        PurchaseLottos lottos = PurchaseLottos.of(createPurchaseLottos());
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(winLotto, 10);
        LottoGameDto gameDto = new LottoGameDto(lottos, winningLotto);
        lottoGameService.game(gameDto);
        assertThat(ResultLotto.당첨1위.getCount()).isEqualTo(1);
        assertThat(ResultLotto.당첨4위.getCount()).isEqualTo(2);
    }

    private List<Lotto> createPurchaseLottos() {
        return List.of(
                createLotto(List.of(1,2,3,4,5,6)),
                createLotto(List.of(1,2,3,4,56,7)),
                createLotto(List.of(1,2,3,4,8,7))
        );
    }

    private Lotto createLotto(List<Integer> lotto) {
        return new Lotto(lotto);
    }

}