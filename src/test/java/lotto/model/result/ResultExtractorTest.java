package lotto.model.result;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultExtractorTest {
    private final Lotto winningNumber = new Lotto(List.of(3, 16, 20, 23, 27, 22));
    private final WinningLotto winningLotto = new WinningLotto(winningNumber, new BonusNumber("7"));
    List<Lotto> fixedLottoNumbers = List.of(
            new Lotto(List.of(3, 16, 20, 35, 44, 45)),
            new Lotto(List.of(3, 16, 20, 23, 27, 45)),
            new Lotto(List.of(1, 9, 10, 16, 25, 26)),
            new Lotto(List.of(3, 16, 20, 23, 27, 7)),
            new Lotto(List.of(1, 6, 18, 21, 41, 45)),
            new Lotto(List.of(3, 16, 20, 35, 43, 45))
    );
    private final Lottos lottos = new Lottos(fixedLottoNumbers);
    private ResultExtractor resultExtractor = new ResultExtractor(winningLotto, lottos);

    @Test
    @DisplayName("랭크 추출 테스트")
    void displayLottoResult() {
        Map<Rank, Integer> result = resultExtractor.extract();

        Map<Rank, Integer> expected = new HashMap<>();
        expected.put(Rank.FIRST, 0);
        expected.put(Rank.SECOND, 1);
        expected.put(Rank.THIRD, 1);
        expected.put(Rank.FOURTH, 0);
        expected.put(Rank.FIFTH, 2);
        expected.put(Rank.MISS, 2);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(expected);
    }
}
