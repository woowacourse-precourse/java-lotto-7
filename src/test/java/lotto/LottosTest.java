package lotto;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

        Map<String, Integer> LottoResult =  myLottos.getLottoResult(winningLotto, bonusNumber);
        //then
        Assertions.assertThat(LottoResult.get(rank)).isEqualTo(count);
    }
}