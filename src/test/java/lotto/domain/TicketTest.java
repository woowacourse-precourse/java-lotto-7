package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {
    @DisplayName("로또 구입은 1000원 단위로 구입하지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입은_1000원_단위로_구입하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1001, List.of(1, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1001, List.of(1, 2, 3, 4, 5, 55), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1이상_45이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1001, List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1001, List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1001, List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("여러개의 당첨 내역 결과 검증")
    @Test
    void 여러개의_당첨_결과_검증() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 16)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16))
        );
        Ticket ticket = new Ticket(lottos, 6000, List.of(1, 2, 3, 4, 5, 6), 7);
        EnumMap<Prize, Integer> result = ticket.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(0);
        assertThat(result.get(Prize.SECOND)).isEqualTo(2);
        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(3);
    }

    @DisplayName("수익률은 소수점 두자리에서 반올림 한다.(내림)")
    @Test
    void 수익률은_소수점_두자리에서_반올림한다_내림() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16))
        );
        Ticket ticket = new Ticket(lottos, 3000, List.of(1, 2, 3, 4, 5, 6), 7);
        double earningRate = ticket.getEarningRate();
        assertThat(earningRate).isEqualTo(3.3); // 3.333...
    }

    @DisplayName("수익률은 소수점 두자리에서 반올림 한다.(올림)")
    @Test
    void 수익률은_소수점_두자리에서_반올림한다_올림() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 15))
        );
        Ticket ticket = new Ticket(lottos, 7000, List.of(1, 2, 3, 4, 5, 6), 7);
        double earningRate = ticket.getEarningRate();
        assertThat(earningRate).isEqualTo(214.3); // 214.285714286
    }

    private List<Lotto> getLottos() {
        return List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}