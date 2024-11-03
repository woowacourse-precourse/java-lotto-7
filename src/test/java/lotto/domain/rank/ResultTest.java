package lotto.domain.rank;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Payment;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.AnswerNumbers;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningLotto;
import lotto.global.contents.LottoDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    Result result;

    @BeforeEach
    void setUp() {
        result = Result.of(generateLottos(), generateAnswerNumbers());
    }

    @DisplayName("수익률 계산 기능")
    @Test
    void 수익률_계산_테스트() {
        Payment payment = Payment.of(3_000, LottoDetail.PRICE);

        double expected = payment.divide(calculateTotal()) * 100;

        assertThat(result.calculateProfitRate(payment)).isEqualTo(expected);
    }

    private long calculateTotal() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank ->
                        (long) result.getCount(rank) * rank.getPrize())
                .sum();
    }

    private AnswerNumbers generateAnswerNumbers() {
        WinningLotto winningLotto = WinningLotto.of(
                List.of(1, 2, 3, 4, 5, 6));

        return AnswerNumbers.from(
                winningLotto,
                BonusNumber.valueOf(winningLotto, 7)
        );
    }

    private Lottos generateLottos() {
        return Lottos.from(generateLottoList());
    }

    private List<Lotto> generateLottoList() {
        return List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 3, 4, 5, 7, 8))
        );
    }
}
