package lotto.system;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import lotto.system.lottoGetter.LottoTicketFactory;
import lotto.system.unit.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketFactoryTest {

    @Test
    @DisplayName("로또 티켓의 개수가 주어진 수량과 일치하는지 테스트")
    void generate_createsCorrectNumberOfTickets() {

        // given
        int quantity = 5;

        // when
        List<LottoTicket> lottoTickets = LottoTicketFactory.generate(quantity);

        // then
        assertEquals(quantity, lottoTickets.size(), "생성된 로또 티켓의 수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("생성된 로또 번호가 중복이 없고 유효 범위 내에 있는지 테스트")
    void generateLotto_createsUniqueNumbersWithinRange() {

        // when
        LottoTicket lottoTicket = LottoTicketFactory.generate(1).get(0);

        // then1 : 로또 번호의 개수가 6개인지 확인
        assertEquals(6, lottoTicket.getTicket().size(), "로또 번호의 개수가 6개가 아닙니다.");

        // then2 : 중복이 없는지 확인
        assertEquals(new HashSet<>(lottoTicket.getTicket()).size(), lottoTicket.getTicket().size(), "로또 번호에 중복이 있습니다.");

        // then3 : 각 번호가 지정된 범위 내에 있는지 확인
        assertTrue(lottoTicket.getTicket().stream().allMatch(number ->
                        LOTTO_NUMBER_LOWER_BOUND <= number.getValue() && number.getValue() <= LOTTO_NUMBER_UPPER_BOUND),
                "로또 번호가 유효한 범위를 벗어났습니다.");
    }
}