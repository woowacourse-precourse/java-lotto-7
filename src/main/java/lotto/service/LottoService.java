package lotto.service;

import lotto.Lotto;
import lotto.model.LottoResult;
import lotto.model.Prize;
import lotto.valid.LottoNumbersValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public List<Lotto> buyLottos(int price) {
        int numberOfLottos = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    public LottoResult evaluateLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoNumbersValidator.validate(winningNumbers);

        Map<Prize, Integer> prizeCounts = new HashMap<>();
        double totalPrizeMoney = 0;

        for (Lotto lotto : lottos) {
            Prize prize = getPrize(lotto, winningNumbers, bonusNumber);
            if(prize != null){
                prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
                totalPrizeMoney += prize.getAmount();
            }
        }

        double roi = (totalPrizeMoney / (lottos.size() * 1000)) * 100;
        return new LottoResult(prizeCounts, roi);
    }

    private Prize getPrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        if (matchCount == 6) return Prize.FIRST;
        if (matchCount == 5 && bonusMatch) return Prize.SECOND;
        if (matchCount == 5) return Prize.THIRD;
        if (matchCount == 4) return Prize.FOURTH;
        if (matchCount == 3) return Prize.FIFTH;
        return null;
    }
}
