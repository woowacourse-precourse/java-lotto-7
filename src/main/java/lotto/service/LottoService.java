package lotto.service;

import lotto.dto.LottoTicketsDto;
import lotto.dto.MoneyDto;

public interface LottoService {

    MoneyDto createMoney(String money);

    LottoTicketsDto generateLottoTickets();
}
