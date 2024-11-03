package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPrize;

public class LottoManager {
    private final List<Lotto> lotties = new ArrayList<>();
    private Long money;
    private List<Integer> winLottiesCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));; //Enum 에 대응되는 당첨 로또 개수
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    // 금액만큼 로또 발권 진행
    public LottoManager(Long money) {
        this.money = money;
        for (int i = 0; i<(money/1000);i++){
            this.lotties.add(this.issueLotto());
        }
    }

    private Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    // 로또들의 당첨 여부 확인
    public void checkLottiesWin() {
        for (Lotto lotto : this.lotties) {
            this.isLottoWin(lotto);
        }
    }

    public void isLottoWin(Lotto lotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (this.isNumberMatch(number)){
                count++;
            }
        }

        if (count>=3) {
            this.checkFifthPrize(count, this.isBonusNumberMatch(lotto.getNumbers())); //check 함수가 연달아서 발생함.
        }
    }

    private boolean isNumberMatch(Integer lottoNumber) {
        for (Integer winNumber : this.winningNumbers) {
            if(winNumber.equals(lottoNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBonusNumberMatch(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if(number.equals(this.bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    private void checkFifthPrize(int count, boolean bonus) {
        if (count ==3) {
            int currentCount = winLottiesCount.get(0);
            winLottiesCount.set(0, currentCount + 1);
            return;
        }
        this.checkFourthPrize(count, bonus);
    }

    private void checkFourthPrize(int count, boolean bonus) {
        if (count ==4) {
            int currentCount = winLottiesCount.get(1);
            winLottiesCount.set(1, currentCount + 1);
            return;
        }
        this.checkThirdPrize(count, bonus);
    }

    private void checkThirdPrize(int count, boolean bonus) {
        if (count ==5 && !bonus) {
            int currentCount = winLottiesCount.get(2);
            winLottiesCount.set(2, currentCount + 1);
            return;
        }
        this.checkSecondPrize(count, bonus);
    }

    private void checkSecondPrize(int count, boolean bonus) {
        if (count ==5 && bonus) {
            int currentCount = winLottiesCount.get(3);
            winLottiesCount.set(3, currentCount + 1);
            return;
        }
        this.checkFirstPrize(count);
    }

    private void checkFirstPrize(int count) {
        if (count == 6){
            int currentCount = winLottiesCount.get(4);
            winLottiesCount.set(4, currentCount + 1);
        }
    }

    public Double calculateEarnRate() {
        double earnRate = ((double) this.sumOfLotto() / (double) this.money)*100;
        return Math.round(earnRate * 10) / 10.0;
    }

    private int sumOfLotto() {
        int index=0;
        int sum = 0;
        for (LottoPrize prize : LottoPrize.values()){
            sum += ( prize.getIntPrize() * this.winLottiesCount.get(index));
            index++;
        }
        return sum;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinLottiesCount() {
        return winLottiesCount;
    }
}
