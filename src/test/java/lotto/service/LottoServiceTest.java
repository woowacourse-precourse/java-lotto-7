package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoWinningNumbers;
import lotto.dto.lottoWinningResultDto.LottoWinningResult;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final InputView inputView = new InputViewImpl();
    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    public void Money객체를_로또_구매_수로_바꿔준다() {
        // given
        Money money = new Money("1000");

        // when
        int number = lottoService.calculatePurchasableLottoCount(money);
        int expected = 1;

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }

    @Test
    public void 로또를_구매_수_만큼_발행_해야_한다() {
        // given
        int purchasableLottoCount = 11;

        // when
        List<Lotto> lottos = lottoService.issueLotto(purchasableLottoCount);
        int expected = 11;

        // then
        Assertions.assertThat(lottos.size()).isEqualTo(expected);
    }

    @Test
    public void 로또의_당첨_결과를_반환_해야_한다() {
        // given
        // 로또 데이터 생성
        // 로또 당첨 번호 생성
        List<Lotto> lottos = new ArrayList<>();
        Integer[][] lottoList = {
                {1, 2, 3, 4, 5, 6}, // 전체 일치
                {1, 2, 3, 4, 5, 6}, // 전체 일치
                {1, 2, 3, 4, 5, 6}, // 전체 일치 총 3개
                {1, 2, 3, 4, 5, 7}, // 5개일치, 보너스 볼 일치
                {1, 2, 3, 4, 5, 7}, // 5개일치, 보너스 볼 일치 총 2개
                {1, 2, 3, 4, 5, 8}, // 5개일치, 보너스 볼 불일치 총 1개
                {2, 3, 4, 5, 8, 9}, // 4개 일치 총 1개
                {2, 3, 4, 8, 9, 10}, // 3개 일치 총 1개
                {7, 8, 9, 10, 11, 12} // 0개 일치 총 1개
        };

        for (int i = 0; i < lottoList.length; i++) {
            lottos.add(new Lotto(List.of(lottoList[i])));
        }

        LottoWinningNumbers lottoWinningNumbers
                = new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        LottoWinningResult lottoWinningResult = lottoService.analyzeWinningResult(lottoWinningNumbers, lottos);
        LottoWinningResult expected = new LottoWinningResult(3, 2, 1, 1, 1);

        // then
        Assertions.assertThat(lottoWinningResult).isEqualTo(expected);
    }

    @Test
    public void 로또_당첨_결과를_바탕으로_수익률을_계산_해야_한다() {
        // given
        // 로또 당첨 결과
        LottoWinningResult lottoWinningResult = new LottoWinningResult(1, 0, 0, 0, 0);
        int lottoCount = 2000000;

        // when
        double lottoRateOfReturn = lottoService.analyzeLottoRateOfReturn(lottoWinningResult, lottoCount);
        double expected = 100;

        // then
        Assertions.assertThat(lottoRateOfReturn).isEqualTo(expected);
    }
}