package lotto.temp;

import lotto.model.Lotto;
import lotto.util.CommonIo;

import java.util.ArrayList;
import java.util.List;

public class Statics {
    private final CommonIo io;

    public Statics(CommonIo io) {
        this.io = io;
    }

    // TODO : 일치 숫자 계산과 결과를 리스트로 만드는 기능의 분리 필요
    public List<Integer> compareLottos(List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matches = new ArrayList<>();

        lottos.forEach(lotto -> {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            matches.add(matchCount);
        });

        return matches;
    }

    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public float calculateProfit(int money, int totalPrize){
        float profit = ((float)totalPrize / money) * 100;
        return Math.round(profit * 10) / 10.0f;
    }

}
