package lotto.service;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int price) {
        return price / 1000;
    }
}
