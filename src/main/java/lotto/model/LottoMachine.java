package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public List<Lotto> generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
        return purchasedLottos;
    }

    public void setWinningLotto(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public void setBonusNumbers(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if(winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Rank> checkResults() {
        List<Rank> results = new ArrayList<>();
        for(Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(num -> winningLotto.getNumbers().contains(num))
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            results.add(Rank.valueOf(matchCount, matchBonus));
        }
        return results;
    }
}
