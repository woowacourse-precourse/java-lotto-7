package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRule;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {
    private final LottoMatcher lottoMatcher = new LottoMatcher();

    @Test
    void 모든_번호가_일치할_경우_6개_일치() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        assertThat(result.get(LottoRule.SIX_MATCH)).isEqualTo(1);
    }

    @Test
    void 보너스_일치하여_5개_일치와_보너스_볼_일치() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        assertThat(result.get(LottoRule.FIVE_MATCH_BONUS)).isEqualTo(1);
    }

    @Test
    void 보너스_없이_5개_일치만() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        assertThat(result.get(LottoRule.FIVE_MATCH)).isEqualTo(1);
    }

    @Test
    void 네_개_일치() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 10, 11))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        assertThat(result.get(LottoRule.FOUR_MATCH)).isEqualTo(1);
    }

    @Test
    void 세_개_일치() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        assertThat(result.get(LottoRule.THREE_MATCH)).isEqualTo(1);
    }

    @Test
    void 일치_없는_경우_결과에_포함되지_않음() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(20, 21, 22, 23, 24, 25))
        );
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRule, Integer> result = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);

        for (LottoRule rule : LottoRule.values()) {
            assertThat(result.getOrDefault(rule, 0)).isEqualTo(0);
        }
    }
}