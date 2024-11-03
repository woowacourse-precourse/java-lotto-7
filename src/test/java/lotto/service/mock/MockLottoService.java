package lotto.service.mock;

import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.service.LottoService;

public class MockLottoService implements LottoService {
    @Override
    public MoneyDto createMoney(String money) {
        throw new IllegalStateException("동작 정지");
    }

    @Override
    public LottoListDto generateLottoList() {
        return null;
    }
}
