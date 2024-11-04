package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    private final LottoRepository lottoRepository;

    public LotteryService(LottoRepository lottoRepository) {
        this.lottoRepository = LottoRepository.getInstance();
    }

    public List<String> buyLotto(Integer purchaseMoney) {
        Integer lottoAmount = getAmountByMoney(purchaseMoney);
        createLottos(lottoAmount);
        return getBuyResult();
    }

    public List<String> confirmWinnings(List<String> winningNums, String bonusNum) {
        for (Lotto lotto : lottoRepository.findAllLottos()) {
            lotto.match(winningNums, bonusNum);
            incrementWinningByLotto(lotto);
        }
        return getWinningResult();
    }

    private List<String> getWinningResult() {
        List<String> result = new ArrayList<>();
        result.add("당첨 통계");
        result.add("---");
        lottoRepository.getWinningMap().forEach((winning, count) -> {
            result.add(winning.getWinningMessage(count));
        });
        result.add(getProfitRate());
        return result;
    }

    private String getProfitRate() {
        int totalPrize = lottoRepository.getTotalPrize();
        int purchaseMoney = lottoRepository.getLottoCount() * 1000;
        double rate = (double) totalPrize / purchaseMoney * 100;
        double roundedRate = Math.round(rate * 10) / 10.0;
        return "총 수익률은 " + roundedRate + "%입니다.";
    }

    private List<String> getBuyResult() {
        List<String> result = new ArrayList<>();
        result.add("\n" + lottoRepository.getLottoCount()+"개를 구매했습니다.");
        lottoRepository.findAllLottos().forEach(lotto -> result.add(lotto.toString()));
        return result;
    }

    private void incrementWinningByLotto(Lotto lotto) {
        Winning.getWinning(lotto.getMatchCount(), lotto.getBonusExist())
                .ifPresent(lottoRepository::incrementWinning);
    }

    private void createLottos(Integer lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            lottoRepository.addLotto(new Lotto(createLottoNums()));
        }
    }

    private List<Integer> createLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Integer getAmountByMoney(Integer purchaseMoney) {
        return purchaseMoney / 1000;
    }

}
