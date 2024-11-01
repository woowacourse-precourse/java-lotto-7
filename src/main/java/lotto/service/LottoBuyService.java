package lotto.service;

import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;

public interface LottoBuyService {

    MoneyDto createMoney(String money);

    LottoListDto generateLottoList();
}
