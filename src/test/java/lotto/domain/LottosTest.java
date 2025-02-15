package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class LottosTest {

    Lottos lottos;
    TargetLotto targetLotto = new TargetLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @Test
    void 일등_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(6, 5, 4, 3, 2, 1))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.FIRST)).isEqualTo(2);
    }

    @Test
    void 이등_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(7, 5, 4, 2, 3, 1))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.SECOND)).isEqualTo(2);
    }

    @Test
    void 삼등_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 11)),
                        new Lotto(List.of(17, 5, 4, 2, 3, 1))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.THIRD)).isEqualTo(2);
    }

    @Test
    void 사등_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 14, 5, 11)),
                        new Lotto(List.of(17, 5, 7, 2, 3, 1))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.FORTH)).isEqualTo(2);
    }

    @Test
    void 오등_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 23, 14, 5, 11)),
                        new Lotto(List.of(7, 5, 14, 2, 43, 1))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.FIFTH)).isEqualTo(2);
    }

    @Test
    void 낙첨_테스트() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 23, 14, 15, 11)),
                        new Lotto(List.of(17, 5, 14, 2, 43, 7))
                )
        );

        Map<LottoGrade, Integer> lottoCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(lottoCountMap.size()).isEqualTo(1);
        Assertions.assertThat(lottoCountMap.get(LottoGrade.FAIL)).isEqualTo(2);
    }
}
