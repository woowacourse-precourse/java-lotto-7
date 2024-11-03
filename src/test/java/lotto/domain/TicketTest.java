package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Ticket(getLottos(), 1000, List.of(1, 2, 3, 4, 5, 6), 6))
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
        assertThat(earningRate).isEqualTo(33.3); // 33.333...
    }

    @DisplayName("수익률은 소수점 두자리에서 반올림 한다.(올림)")
    @Test
    void 수익률은_소수점_두자리에서_반올림한다_올림() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 15))
        );
        Ticket ticket = new Ticket(lottos, 7000, List.of(1, 2, 3, 4, 5, 6), 7);
        double earningRate = ticket.getEarningRate();
        assertThat(earningRate).isEqualTo(2142.9); // 2142.85714286
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