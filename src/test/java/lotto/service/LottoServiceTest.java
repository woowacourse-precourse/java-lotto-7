package lotto.service;

import java.util.List;
import lotto.common.RandomNumberGenerator;
import lotto.domain.IssuedRandomLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.LottoStatisticsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("1000원을 넣으면 로또 하나가 생성된다.")
    @Test
    void 로또_발행_1000원으로_1장() {
        // given
        LottoService lottoService = new LottoService(new RandomNumberGenerator());

        // when
        IssuedRandomLotto issuedRandomLotto = lottoService.createIssuedRandomLotto(1000);

        // then
        Assertions.assertThat(issuedRandomLotto.getIssuedLottos().size()).isEqualTo(1);
    }

    @DisplayName("100000원을 넣으면 로또 100개가 생성된다.")
    @Test
    void 로또_발행_100000원으로_100장() {
        // given
        LottoService lottoService = new LottoService(new RandomNumberGenerator());

        // when
        IssuedRandomLotto issuedRandomLotto = lottoService.createIssuedRandomLotto(100000);

        // then
        Assertions.assertThat(issuedRandomLotto.getIssuedLottos().size()).isEqualTo(100);
    }

    @DisplayName("로또 두장으로 2등과 5등에 당첨됐을 때 기대한 수익률을 반환한다.")
    @Test
    void 로또_결과_DTO_확인() {
        // given
        LottoService lottoService = new LottoService(new RandomNumberGenerator());
        Lotto second = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto fifth = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        IssuedRandomLotto issuedRandomLotto = new IssuedRandomLotto(new RandomNumberGenerator(), List.of(second, fifth),
                2000);
        LottoResult lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoStatisticsDto lottoStatisticsDto = lottoService.calculateLottoStatistics(lottoResult, issuedRandomLotto);

        // then
        Assertions.assertThat(lottoStatisticsDto.lottoRanks()).isEqualTo(List.of(LottoRank.SECOND, LottoRank.FIFTH));
        Assertions.assertThat(lottoStatisticsDto.lottoRateOfProfit()).isEqualTo(1500250.0);
    }
}
