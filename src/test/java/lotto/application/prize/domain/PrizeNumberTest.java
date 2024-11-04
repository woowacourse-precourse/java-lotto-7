package lotto.application.prize.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeNumber 테스트")
class PrizeNumberTest {

    @DisplayName("당첨 번호와 보너스 번호로 PrizeNumber 생성 성공")
    @Test
    void 당첨번호와_보너스번호로_생성_성공() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);

        // when
        PrizeNumber prizeNumber = PrizeNumber.of(winnerNumbers, bonusNumber);

        // then
        assertThat(prizeNumber).isNotNull();
    }

    @DisplayName("PrizeNumberResult 반환 성공")
    @Test
    void PrizeNumberResult_반환_성공() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);
        PrizeNumber prizeNumber = PrizeNumber.of(winnerNumbers, bonusNumber);

        // when
        PrizeNumberResult result = prizeNumber.getValue();

        // then
        assertThat(result).isNotNull();
    }

}
