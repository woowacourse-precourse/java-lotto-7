package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;
    private Lotto winningLotto;
    private int bonusNum;
    public LottoList() {
        this.lottoList = new ArrayList<>();
    }
    // 당첨 번호와 보너스 번호를 설정하는 메서드
    public void setWinningNumber(Lotto winningLotto, int bonusNum) {
        validateBonusNumber(winningLotto, bonusNum);
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }
    // 발행 로또 추가 메서드
    public void add(Lotto lotto){
        lottoList.add(lotto);
    }
    private void validateBonusNumber(Lotto winningLotto, int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.checkBonus(bonusNum)) {  // checkBonus 메서드 사용
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
