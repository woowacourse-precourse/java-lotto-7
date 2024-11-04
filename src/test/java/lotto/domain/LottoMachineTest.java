package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구입 금액이 0보다 작거나 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_잘못된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 0보다 커야 합니다.");

        assertThatThrownBy(() -> lottoMachine.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("구입 금액에 따라 로또 티켓이 생성된다. - 1000원당 1개의 티켓 생성")
    @Test
    void 구입_금액에_따라_티켓이_생성된다() {
        int purchaseAmount = 3000;
        List<Lotto> tickets = lottoMachine.generateTickets(purchaseAmount);

        assertThat(tickets).hasSize(3);
    }

    @DisplayName("로또 게임의 결과를 올바르게 계산한다.")
    @Test
    void 로또_결과를_계산한다() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);

        assertThat(result.getResults().get(LottoRank.FIRST)).isEqualTo(1); // 6개 일치
        assertThat(result.getResults().get(LottoRank.FIFTH)).isEqualTo(1); // 3개 일치
        assertThat(result.getResults().get(LottoRank.NONE)).isEqualTo(1);  // 0개 일치
    }

    @DisplayName("로또 티켓이 보너스 번호를 맞춘 경우 로또 결과를 올바르게 계산한다.")
    @Test
    void 로또_티켓이_보너스_번호를_맞춘_경우_계산한다() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);

        assertThat(result.getResults().get(LottoRank.FIRST)).isEqualTo(1); // 6개 일치
        assertThat(result.getResults().get(LottoRank.SECOND)).isEqualTo(1); // 5개 일치 + 보너스 볼 일치
    }

    @DisplayName("모든 티켓이 번호를 맞추지 못한 경우 로또 결과를 올바르게 계산한다.")
    @Test
    void 모든_티켓이_번호를_맞추지_못한_경우_계산한다() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        List<Integer> winningNumbers = List.of(13, 14, 15, 16, 17, 18);
        int bonusNumber = 19;

        LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);

        assertThat(result.getResults().get(LottoRank.NONE)).isEqualTo(2); // 0개 일치
    }
}