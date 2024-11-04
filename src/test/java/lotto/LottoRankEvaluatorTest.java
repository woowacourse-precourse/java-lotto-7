package lotto;

import static lotto.Rank.FIRST;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankEvaluatorTest {

    @DisplayName("구매한 로또 번호의 순위를 매겨서 올바른 결과를 반환한다.")
    @Test
    void 구매한_로또_번호의_1위의_올바른_개수를_반환한다() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 10;
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(createLottos(),numbers,bonusNum);

        Map<Rank,Integer> result = lottoRankEvaluator.getRankCount();
        Assertions.assertThat(result.get(FIRST)).isEqualTo(1);
    }

    @Test
    void 구매한_로또_번호의_2위의_개수를_올바르게_반환한다() {
        List<Integer> numbers = Arrays.asList(7, 12, 18, 25, 36, 43);
        int bonusNum = 44;
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(createLottos(),numbers,bonusNum);

        Map<Rank,Integer> result = lottoRankEvaluator.getRankCount();
        Assertions.assertThat(result.get(SECOND)).isEqualTo(1);
    }

    @Test
    void 구매한_로또_번호의_3위의_개수를_올바르게_반환한다() {
        List<Integer> numbers = Arrays.asList(7, 12, 18, 25, 36, 43);
        int bonusNum = 14;
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(createLottos(),numbers,bonusNum);

        Map<Rank,Integer> result = lottoRankEvaluator.getRankCount();
        Assertions.assertThat(result.get(THIRD)).isEqualTo(1);
    }

    private List<Lotto> createLottos() {
        Lotto set1 = createSingleLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto set2 = createSingleLotto(Arrays.asList(7, 12, 18, 25, 36, 44));
        Lotto set3 = createSingleLotto(Arrays.asList(2, 9, 16, 23, 30, 38));
        Lotto set4 = createSingleLotto(Arrays.asList(5, 13, 20, 27, 34, 42));
        Lotto set5 = createSingleLotto(Arrays.asList(1, 8, 19, 26, 35, 43));

        return Arrays.asList(set1,set2,set3,set4,set5);
    }

    private Lotto createSingleLotto(List<Integer> number) {
        return new Lotto(number);
    }

}
