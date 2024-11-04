package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoServiceImpl implements LottoService {
    private final List<Lotto> lottoList;
    private final int ticketPrice = 1000;

    public LottoServiceImpl() {
        this.lottoList = new ArrayList<>();
    }

    @Override
    public void buyLotto(int amount) {
        validateAmount(amount);
        int count = amount / ticketPrice;
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    @Override
    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void validateAmount(int amount) {
        if (amount % ticketPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    @Override
    public Rank checkWinning(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return Rank.of(matchCount, matchBonus);
    }

    @Override
    public Map<Rank, Integer> calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottoList) {
            Rank rank = checkWinning(lotto, winningNumbers, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}
