package lotto.application.prize.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CreateBonusNumberService 테스트")
class CreateBonusNumberServiceTest {

    @Test
    @DisplayName("보너스 번호 생성 성공")
    void 보너스번호_생성_성공() {
        // given
        CreateBonusNumberService service = new CreateBonusNumberService();
        WinnerNumbers winnerNumbers = WinnerNumbers.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));

        // when
        BonusNumber bonusNumber = service.execute(winnerNumbers, 7);

        // then
        assertThat(bonusNumber.getValue()).isEqualTo(7);
    }

}
