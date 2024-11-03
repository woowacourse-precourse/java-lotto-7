package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 구입금액에_따른_로또_수량_생성_테스트() {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateLottos(3000);
        assertThat(lottos).hasSize(3);
    }

    @Test
    void 구입_금액_유효성_검사_테스트() {
        assertThatThrownBy(() -> Validator.validatePrice(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 양의 정수로 입력되어야 합니다.");

        assertThatThrownBy(() -> Validator.validatePrice(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000단위로 입력되어야 합니다.");
    }

    @Test
    void 당첨_번호_입력_유효성_검사_테스트() {
        assertThatThrownBy(() -> Validator.validateWinNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> Validator.validateWinNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다.");

        assertThatThrownBy(() -> Validator.validateWinNumbers(List.of(1, 2, 3, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 보너스_번호_입력_유효성_검사_테스트() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 3;

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void 발행_번호와_당첨_번호_비교_검사() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto.getMatchResult(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isEqualTo(LottoResult.SIX);

        assertThat(winningLotto.getMatchResult(new Lotto(List.of(1, 2, 3, 4, 5, 7))))
                .isEqualTo(LottoResult.FIVE_WITH_BONUS);

        assertThat(winningLotto.getMatchResult(new Lotto(List.of(1, 2, 3, 4, 5, 8))))
                .isEqualTo(LottoResult.FIVE);
    }

    @Test
    void 총_당첨_금액_계산_테스트() {
        LottoStatistics statistics = new LottoStatistics(3000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        statistics.processTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        ), winningLotto);

        int totalPrize = statistics.calculateTotalPrize();
        assertThat(totalPrize).isEqualTo(2000000000 + 30000000);
    }

    @Test
    void 수익률_계산_테스트() {
        LottoStatistics statistics = new LottoStatistics(3000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        statistics.processTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ), winningLotto);

        double profitRate = statistics.calculateProfitRate();
        assertThat(profitRate).isCloseTo(66666666.7, within(0.1));
    }

    @Test
    void 수익률_소수점_출력_테스트() {
        int price = 5000;
        LottoStatistics statistics = new LottoStatistics(price);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        statistics.processTickets(List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(17, 18, 19, 20, 21, 22)),
                new Lotto(List.of(23, 24, 25, 26, 27, 28)),
                new Lotto(List.of(29, 30, 31, 32, 33, 34))
        ), winningLotto);

        double profitRate = statistics.calculateProfitRate();
        assertThat(profitRate).isEqualTo(100.0);
    }

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
