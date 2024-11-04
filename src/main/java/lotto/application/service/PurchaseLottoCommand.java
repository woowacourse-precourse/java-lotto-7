package lotto.application.service;

import java.util.ArrayList;
import java.util.List;
import lotto.application.dto.request.PurchaseLottoRequest;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.port.input.PurchaseLottoUsecase;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.LottoMachine;

public class PurchaseLottoCommand implements PurchaseLottoUsecase {

    private final LottoRepository lottoRepository;
    private final LottoMachine lottoMachine;

    public PurchaseLottoCommand(LottoRepository lottoRepository, LottoMachine lottoMachine) {
        this.lottoRepository = lottoRepository;
        this.lottoMachine = lottoMachine;
    }

    @Override
    public PurchaseLottoResponse execute(PurchaseLottoRequest purchaseLottoRequest) {
        List<Lotto> lottos = new ArrayList<>();
        PurchaseAmount purchaseAmount = purchaseLottoRequest.purchaseAmount();

        while (purchaseAmount.isEnough()) {
            purchaseAmount.deduct();

            Lotto lotto = lottoMachine.create();
            lottoRepository.save(lotto);
            lottos.add(lotto);
        }

        return new PurchaseLottoResponse(lottos.size(), lottos);
    }
}
