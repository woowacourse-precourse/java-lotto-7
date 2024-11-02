package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.dto.LottoPurchaseResponse;
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

    public LottoPurchaseResponse createLottoNumbers() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.findOne();

        List<Lotto> lottoList = createLottoList(lottoPurchase.getAmount());
        lottoRepository.save(lottoList);

        return LottoPurchaseResponse.of(lottoPurchase, lottoList);
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Lotto> createLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(getRandomNumbers()));
        }

        return lottoList;
    }
}
