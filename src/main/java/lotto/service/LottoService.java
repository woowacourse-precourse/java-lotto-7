package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void createLottoNumbers() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.findOne();

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoPurchase.getAmount(); i++) {
            lottoList.add(new Lotto(getRandomNumbers()));
        }

        lottoRepository.save(lottoList);
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
