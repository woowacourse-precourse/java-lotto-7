package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

    @DisplayName("로또 번호의 당첨 결과를 확인한다.")
    @ParameterizedTest
    @CsvSource({"1등, 1","2등, 1","3등, 2","4등, 1","5등, 2"})
    void 로또_번호의_당첨_결과를_확인한다(String rank, Integer count) {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 30;
        //when
        Lottos myLottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), //1등
                new Lotto(List.of(1, 2, 3, 4, 5, 30)),//2등

                new Lotto(List.of(1, 2, 3, 4, 5, 8)),//3등
                new Lotto(List.of(3, 2, 4, 1, 5, 13)),//3등

                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4등

                new Lotto(List.of(1, 2, 3, 8, 9, 10)),// 5등
                new Lotto(List.of(1, 2, 3, 8, 9, 10))// 5등
        ));

        Map<String, Integer> LottoResult =  myLottos.getResult(winningLotto, bonusNumber);
        //then
        Assertions.assertThat(LottoResult.get(rank)).isEqualTo(count);
    }

    @DisplayName("총 상금 계산 결과 테스트")
    @Test
    void 총_상금_계산_결과_테스트() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 10;
        //when
        Lottos myLottos = new Lottos(
                List.of(new Lotto(List.of(1,2,3,4,5,10))
                        ,new Lotto(List.of(1,2,3,4,5,13)))); //2등당첨,3등당첨: 총상금 3천150만원
        Map<String, Integer> lottoResult = myLottos.getResult(winningLotto, bonunsNumber);
        //then
        double totalPrizeMoney = myLottos.getTotalPrizeMoney(lottoResult);
        Assertions.assertThat(totalPrizeMoney).isEqualTo(30000000+1500000);
    }

    @DisplayName("총 수익률을 계산 테스트")
    @Test
    void 총_수익률_계산_결과를_확인한다() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 10;
        int usingMoney = 150000;

        //when
        Lottos mylottos = new Lottos(List.of(
                new Lotto(List.of(1,2,3,11,12,13)),
                new Lotto(List.of(1,2,3,11,12,14)),
                new Lotto(List.of(1,2,3,11,12,15)) //5등 3개 당첨: 15,000원
        ));
        Map<String, Integer> lottoResult = mylottos.getResult(winningLotto, bonunsNumber);

        //then
        double returns = mylottos.calculateReturns(lottoResult);
        Assertions.assertThat(returns).isEqualTo(10.0);
    }
}