package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.Lotto;

public class LottoManager {
    private final List<Lotto> lotties = new ArrayList<>();
    private Integer money;
    private List<Integer> winLottiesCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));; //Enum 에 대응되는 당첨 로또 개수
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoManager(Integer money) {
        this.money = money;
        for (int i = 0; i<(money/1000);i++){
            this.lotties.add(this.issueLotto());
        }
    }

    private Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
    
    public List<Lotto> getLotties() {
        return lotties;
    }

    public List<Integer> getWinLottiesNumber() {
        return winLottiesCount;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
