package lotto.application.service;

import java.util.ArrayList;
import java.util.List;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.port.input.PurchaseLottoUsecase;
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
    public PurchaseLottoResponse execute(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        int totalCost = numberOfLottos * 1000;
        List<Lotto> lottos = new ArrayList<>(numberOfLottos);

        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = lottoMachine.create();
            lottoRepository.save(lotto);
            lottos.add(lotto);
        }

        return new PurchaseLottoResponse(numberOfLottos, lottos, totalCost);

    }
}
