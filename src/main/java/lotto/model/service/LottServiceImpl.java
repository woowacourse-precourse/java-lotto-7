package lotto.model.service;

public class LottServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int amount) {
        return amount / 1000;
    }
}
