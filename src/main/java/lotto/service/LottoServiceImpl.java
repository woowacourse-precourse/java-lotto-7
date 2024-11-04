package lotto.service;

import java.util.List;
import lotto.enums.LottoInfo;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoFactory;
import lotto.model.vo.Money;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public List<Lotto> buyLotto(Money money) {
        int lottoCount = calculateLottoCount(money);
        for (int count = 0; count < lottoCount; count++) {
            lottoRepository.save(LottoFactory.getInstance().createLotto());
        }
        return lottoRepository.findAllLotto();
    }

    private static int calculateLottoCount(Money money) {
        return money.value() / LottoInfo.LOTTO_PRICE.getValue();
    }
}
