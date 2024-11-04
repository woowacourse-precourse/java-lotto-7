package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.PurchaseAmountDto;
import lotto.repository.LottoRepository;
import lotto.repository.PurchaseAmountRepository;
import lotto.utils.LottoUtils;
import lotto.view.OutputView;

import java.util.List;

public class PurchaseAmountService {

    private final LottoRepository lottoRepository = LottoRepository.getInstance();
    private final PurchaseAmountRepository purchaseAmountRepository = PurchaseAmountRepository.getInstance();

    public void generateLotto(final PurchaseAmountDto dto) {
        for (int i = 0; i < dto.value; i++) {
            Lotto lotto = new Lotto(LottoUtils.generateLottoNumber());
            lottoRepository.save(lotto);
        }
        printLotto();
    }

    private void printLotto() {
        List<Lotto> lottos = lottoRepository.findAll();
        for (Lotto lotto : lottos) {
            OutputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    public void savePurchaseAmount(final PurchaseAmountDto dto) {
        purchaseAmountRepository.save(dto.toEntity());
    }
}