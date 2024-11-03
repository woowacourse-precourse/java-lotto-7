package lotto.application.ticket.service;

import static lotto.application.ticket.domain.ticket.LottoNumberRule.END_INCLUSIVE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.SIZE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class UniqueNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE.getValue(),
                END_INCLUSIVE.getValue(),
                SIZE.getValue()
        );
    }

}
