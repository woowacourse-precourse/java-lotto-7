package lotto.service;

import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;

public interface LottoService {

    MoneyDto createMoney(String money);

    LottoListDto generateLottoList();
}
