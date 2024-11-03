package lotto.controller;

import lotto.dto.PurchaseAmountRequestDto;
import lotto.model.Lottos;
import lotto.service.genaration.GenerateService;
import lotto.view.OutputView;

public class LottoController {
    public static Lottos run(PurchaseAmountRequestDto purchaseAmountRequestDto) {
        int numberOfLotto = purchaseAmountRequestDto.getPurchaseAmount() / 1000;
        GenerateService lottoGenerator = new GenerateService(numberOfLotto);

        Lottos lottos = lottoGenerator.generateLotos();
        OutputView.printLottos(lottos);
        return lottos;
    }
}
