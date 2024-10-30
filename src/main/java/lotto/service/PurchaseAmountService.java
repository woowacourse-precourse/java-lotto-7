package lotto.service;

import lotto.Lotto;
import lotto.dto.PurchaseAmountDto;
import lotto.repository.LottoRepository;
import lotto.utils.LottoUtils;
import lotto.view.OutputView;

import java.util.List;

public class PurchaseAmountService {

    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public void generateLotto(final PurchaseAmountDto dto) {
        for (int i = 0; i < dto.value; i++) {
            Lotto lotto = new Lotto(LottoUtils.generateLottoNumber());
            lottoRepository.save(lotto);
        }
        printLotto();
    }

    private void printLotto() {
        List<Lotto> lottos = lottoRepository.findAll();
        for(Lotto lotto: lottos) {
            OutputView.printLottoNumbers(lotto.getNumbers());
        }
    }
}
