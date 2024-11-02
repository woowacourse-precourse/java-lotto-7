package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.dto.BonusNumberSaveRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.WinningNumberSaveResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningNumber;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;
import lotto.utils.LottoUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoPurchaseRepository lottoPurchaseRepository;
    private final WinningNumberRepository winningNumberRepository;

    public LottoService(LottoRepository lottoRepository, LottoPurchaseRepository lottoPurchaseRepository, WinningNumberRepository winningNumberRepository) {
        this.lottoRepository = lottoRepository;
        this.lottoPurchaseRepository = lottoPurchaseRepository;
        this.winningNumberRepository = winningNumberRepository;
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

    public WinningNumberSaveResponse saveWinningNumber(String input) {
        List<String> divideBySeparator = LottoUtils.divideBySeparator(",", input);
        List<Integer> result = LottoUtils.convertToIntegerList(divideBySeparator);

        WinningNumber winningNumber = WinningNumber.to(result);
        winningNumberRepository.save(winningNumber);

        int index = winningNumberRepository.findIndexByWinningNumber(winningNumber);

        return new WinningNumberSaveResponse(index, winningNumber);
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

    public void saveBonusNumber(BonusNumberSaveRequest request) {
        WinningNumber winningNumber = winningNumberRepository.findByIndex(request.index());
        int bonusNumber = LottoUtils.parseInt(request.bonusNumber());
        winningNumber.setBonusNumber(bonusNumber);
    }
}
