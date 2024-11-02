package lotto.controller;

import lotto.repository.LottoRepository;
import lotto.service.LotteryService;

import java.util.List;

public class LottoController {

    private final LotteryService lotteryService = new LotteryService(LottoRepository.getInstance());

    public List<String> buyLotto(Integer purchaseMoney) {
        return lotteryService.buyLotto(purchaseMoney);
    }

    public List<String> confirmWinnings(List<String> winningNums, String bonusNum) {
        return lotteryService.confirmWinnings(winningNums, bonusNum);
    }


}
