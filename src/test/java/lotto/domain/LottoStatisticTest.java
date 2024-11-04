package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticTest {

    @Test
    @DisplayName("로또 통계 초기화 및 카운트 계산 테스트")
    void lottoStatistic_카운트_계산() {
        // Given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.createLottos(5);
        List<LottoNumber> winningNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int totalPrice = 5000;

        // When
        LottoStatistic lottoStatistic = new LottoStatistic(lottos, winningLotto, totalPrice);

        // Then
        assertThat(lottoStatistic.getRankCount().get(WinningRank.LAST_PLACE)).isEqualTo(5); // 모든 로또가 0개 일치
        assertThat(lottoStatistic.getRankCount().get(WinningRank.THIRD_PLACE)).isEqualTo(0); // 3개 일치 없음
        assertThat(lottoStatistic.getRankCount().get(WinningRank.FIFTH_PLACE)).isEqualTo(0); // 5개 일치 없음
        assertThat(lottoStatistic.getRankCount().get(WinningRank.SECOND_PLACE)).isEqualTo(0); // 5개 + 보너스 없음
        assertThat(lottoStatistic.getRankCount().get(WinningRank.FIRST_PLACE)).isEqualTo(0); // 6개 일치 없음
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void lottoStatistic_수익률_계산() {
        // Given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.createLottos(10);
        List<LottoNumber> winningNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int totalPrice = 8000;

        Lotto matchingLotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(8), new LottoNumber(9))); // 3개 일치
        Lottos mockLottos = new Lottos(List.of(matchingLotto));

        // When
        LottoStatistic lottoStatistic = new LottoStatistic(mockLottos, winningLotto, totalPrice);

        // Then
        assertThat(lottoStatistic.calculateProfitRate()).isEqualTo(625.0);
    }
}
