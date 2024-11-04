package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningLotto;
    private int bonusNumber;

    public WinningLotto(){
        this.winningLotto = new ArrayList<>();
    }

    public void addWinningLotto(List<Integer> winningLotto){
        Lotto lotto = new Lotto(winningLotto);
        this.winningLotto = lotto.getLottoDetails();
    }

    public List<Integer> getWinningLotto(){
        return new ArrayList<>(winningLotto);
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

    public void saveBonusNumber(int bonusNumber, int max, int min){
        if (this.winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber<min || bonusNumber>max){
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45 입니다.");
        }
        this.bonusNumber = bonusNumber;
    }
}
