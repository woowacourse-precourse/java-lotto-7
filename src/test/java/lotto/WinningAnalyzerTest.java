package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.Lottos;
import lotto.Domain.WinningAnalyzer;
import lotto.Domain.WinningNumbers;
import lotto.Domain.WinningResult;
import lotto.Domain.WinningRules;
import org.junit.jupiter.api.Test;

class WinningAnalyzerTest {

    @Test
    void 로또_번호와_당첨_번호를_비교하여_1등_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.FIRST)).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_2등_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.SECOND)).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_3등_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.THIRD)).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_4등_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.FOURTH)).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_5등_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.FIFTH)).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_미당첨_결과를_확인한다() {
        WinningNumbers winningNumbers = WinningNumbers.create();
        winningNumbers.registerMainNumbers("1,2,3,4,5,6");
        winningNumbers.registerBonus("7");

        Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningAnalyzer analyzer = new WinningAnalyzer();
        WinningResult winningResult = analyzer.analyze(lottos, winningNumbers);

        assertThat(winningResult.getCount(WinningRules.NO_WIN)).isEqualTo(1);
    }
}
