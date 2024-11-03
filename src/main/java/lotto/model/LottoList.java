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
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }


}
