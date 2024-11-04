package lotto.utils;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputHandlerTest {

    Lottos lottos = new Lottos(
            List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)), // FIRST
                    new Lotto(List.of(2, 3, 4, 5, 6, 7)), // SECOND
                    new Lotto(List.of(2, 3, 4, 5, 6, 8)), // THIRD
                    new Lotto(List.of(3, 4, 5, 6, 7, 8)), // FOURTH
                    new Lotto(List.of(4, 5, 6, 7, 8, 9)) // FIFTH
            )
    );

    @DisplayName("로또 번호를 올바른 형식으로 변환한다.")
    @Test
    void shouldConvertToLottoPrintFormat() {

        Assertions.assertThat(OutputHandler.formatLottos(lottos))
                .contains("[1, 2, 3, 4, 5, 6]",
                        "[2, 3, 4, 5, 6, 7]",
                        "[2, 3, 4, 5, 6, 8]",
                        "[3, 4, 5, 6, 7, 8]",
                        "[4, 5, 6, 7, 8, 9]");
    }

    @DisplayName("랭크를 올바른 형식으로 변환한다.")
    @Test
    void shouldConvertToRankPrintFormat() {
        Money money = new Money(5000);

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        Result result = new Result(money, lottos, winningLotto);

        Assertions.assertThat(OutputHandler.formatStatistics(result))
                .contains("3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 1개");
    }
}