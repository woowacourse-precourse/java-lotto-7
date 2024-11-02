package lotto.service;

import lotto.domain.LottoPurchase;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoPurchaseRepository lottoPurchaseRepository;

    public LottoService(LottoRepository lottoRepository, LottoPurchaseRepository lottoPurchaseRepository) {
        this.lottoRepository = lottoRepository;
        this.lottoPurchaseRepository = lottoPurchaseRepository;
    }

    public void saveLottoPurchase(String request) {
        lottoPurchaseRepository.save(LottoPurchase.to(request));
    }
}
