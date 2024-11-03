package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class LottoFactoryTest {

    LottoFactory lottoFactory = new LottoFactory(() -> RandomNumberGenerator.generate());
    TargetLotto targetLotto;

    @BeforeEach
    void 초기화() {
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        targetLotto = new TargetLotto(target, bonus);
    }

    @Test
    void 로또_생성_테스트() {
        long payment = 100000;
        Lottos lottos = lottoFactory.generateLottos(payment);
        Map<LottoGrade, Integer> gradeCountMap = lottos.convertGrades(targetLotto);

        int count = gradeCountMap.values().stream()
                .reduce(0, Integer::sum);

        Assertions.assertThat(count).isEqualTo(100);
    }

    @Test
    void 로또_결과_매핑_테스트() {
        long payment = 2000;
        lottoFactory = new LottoFactory(() -> List.of(1, 2, 5, 4, 3, 7));
        Lottos lottos = lottoFactory.generateLottos(payment);
        Map<LottoGrade, Integer> gradeCountMap = lottos.convertGrades(targetLotto);

        Assertions.assertThat(gradeCountMap.size()).isEqualTo(1);
        Assertions.assertThat(gradeCountMap.get(LottoGrade.SECOND)).isEqualTo(2);
    }

    @Test
    void 로또_생성_예외_테스트() {
        long payment = 4500;

        Assertions.assertThatThrownBy(() -> lottoFactory.generateLottos(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
