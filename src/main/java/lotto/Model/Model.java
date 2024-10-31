package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private List<Lotto> numbers = new ArrayList<Lotto>();
    private List<Integer> winNumbers;
    private int bonusNumber;
    private List<Integer> prizeNum = new ArrayList<>(Collections.nCopies(6, 0));


    public Model(int count) {
        for (int i = 0; i < count; i++) {
            numbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void countPrizeNum() {
        for (Lotto lotto : numbers) {
            int rank = LottoPrize.getRank(lotto.sameNumCount(winNumbers), lotto.checkBonus(bonusNumber));
            prizeNum.set(rank, prizeNum.get(rank)+1);
        }
    }

    public int sumPrizeMoney() {
        return  5000*prizeNum.get(5)+
                50000*prizeNum.get(4)+
                1500000*prizeNum.get(3)+
                30000000*prizeNum.get(2)+
                2000000000*prizeNum.get(1);
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }

    public List<Integer> getPrizeNum() {
        return prizeNum;
    }
}
