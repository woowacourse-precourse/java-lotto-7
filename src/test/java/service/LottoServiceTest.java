package service;

import dto.LottoWinningNumbers;
import dto.lottoWinningResultDto.LottoWinningResult;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.InputViewImpl;

class LottoServiceTest {
    private final InputView inputView = new InputViewImpl();
    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    public void Money객체를_로또_구매_수로_바꿔준다() {
        // given
        Money money = new Money("1000");

        // when
        BigInteger number = lottoService.calculatePurchasableLottoCount(money);
        BigInteger expected = new BigInteger("1");

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }

    @Test
    public void 입금_금액이_많아도_로또_구매_수로_바꿔준다() {
        // given
        Money money = new Money("12345678900000000000000000000000000000000000000000");

        // when
        BigInteger number = lottoService.calculatePurchasableLottoCount(money);
        BigInteger expected = new BigInteger("12345678900000000000000000000000000000000000000");

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }

    @Test
    public void 로또를_구매_수_만큼_발행_해야_한다() {
        // given
        BigInteger purchasableLottoCount = new BigInteger("11");

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
        // TODO: 로또 당첨 결과를 도출하는 메서드
        LottoWinningResult lottoWinningResult = lottoService.analyzeWinningResult(lottoWinningNumbers, lottos);
        LottoWinningResult expected = new LottoWinningResult();

        // then
        Assertions.assertThat(lottoWinningResult).isEqualTo(expected);
    }

    @Test
    public void 로또_당첨_결과를_바탕으로_수익률을_계산_해야_한다() { // TODO: 이거까지 다 만들면 commit
        // given
        // 로또 당첨 결과
        LottoWinningResult lottoWinningResult = new LottoWinningResult();

        // when
        // TODO: 당첨 결과를 가지고 무언가를 하는 친구와 예상 값
        double lottoRateOfReturn = lottoService.analyzeLottoRateOfReturn(lottoWinningResult);
        double expected = 0;

        // then
        Assertions.assertThat(lottoRateOfReturn).isEqualTo(expected);
    }


}