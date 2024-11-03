package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.util.messages.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스_번호가_1이상_45이하_범위를_벗어나면_예외가_발생한다() {
        // given
        int bonusNumber = 55;

        // when, then
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_OVER_RANGE.getMessage());
    }

    @Test
    void 보너스_번호가_이미_당첨_번호에_존재하면_예외가_발생한다() {
        // given
        int bonusNumber = 3;

        // when, then
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_IS_DUPLICATED.getMessage());
    }
}
