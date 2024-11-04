package lotto.application.prize.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Prize 테스트")
class PrizeTest {

    @DisplayName("Id와 PrizeNumber로 Prize 생성 성공")
    @Test
    void ID와_PrizeNumber로_생성_성공() {
        // given
        Long id = 1L;
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);
        PrizeNumber prizeNumber = PrizeNumber.of(winnerNumbers, bonusNumber);

        // when
        Prize prize = Prize.of(id, prizeNumber);

        // then
        assertThat(prize.getId()).isEqualTo(id);
    }

    @DisplayName("PrizeNumberResult 조회 성공")
    @Test
    void PrizeNumberResult_조회_성공() {
        // given
        Long id = 1L;
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);
        PrizeNumber prizeNumber = PrizeNumber.of(winnerNumbers, bonusNumber);
        Prize prize = Prize.of(id, prizeNumber);

        // when
        PrizeNumberResult result = prize.getPrizeNumber();

        // then
        assertThat(result).isNotNull();
    }

}
