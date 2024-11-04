package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

    @DisplayName("로또 번호의 당첨 결과를 확인한다.")
    @ParameterizedTest
    @CsvSource({"1등, 1","2등, 1","3등, 2","4등, 1","5등, 2"})
    void 로또_번호의_당첨_결과를_확인_테스트(String rank, Integer count) {
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

        LottosResult LottoResult =  myLottos.getResult(winningLotto, bonusNumber);
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
        LottosResult lottoResult = myLottos.getResult(winningLotto, bonunsNumber);
        //then
        double totalPrizeMoney = lottoResult.get("총상금");
        Assertions.assertThat(totalPrizeMoney).isEqualTo(30000000+1500000);
    }

    @DisplayName("수익률을 계산 테스트")
    @Test
    void 수익률_계산_결과_테스트() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 10;

        //when
        Lottos mylottos = new Lottos(List.of(
                new Lotto(List.of(16,2,33,11,12,13)),
                new Lotto(List.of(1,2,37,11,12,13)),
                new Lotto(List.of(1,2,33,11,12,13)),
                new Lotto(List.of(1,2,39,11,12,13)),
                new Lotto(List.of(1,2,36,11,12,13)),
                new Lotto(List.of(1,2,3,11,12,15)) //로또 6개 구매: 6000원
        ));//5등 1개 당첨: 5,000원
        LottosResult lottoResult = mylottos.getResult(winningLotto, bonunsNumber);

        //then
        double returns = lottoResult.calculateReturns();
        Assertions.assertThat(returns).isEqualTo(83.3);
    }
}