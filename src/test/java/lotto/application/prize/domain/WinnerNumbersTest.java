package lotto.application.prize.domain;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinnerNumbers 테스트")
class WinnerNumbersTest {
    @Test
    @DisplayName("당첨 번호 생성 성공")
    void 당첨_번호_생성_성공() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        // when
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);

        // then
        Assertions.assertThat(winnerNumbers.getLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

}
