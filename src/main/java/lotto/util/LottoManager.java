package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private Lotto winningLotto;


    public void setWinningLotto(List<Integer> numbers){
        this.winningLotto = new Lotto(numbers);
    }

    public ArrayList<Lotto> purchaseLotto(int amount){
        validateAmount(amount);

        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount/1000; i++) {
            lottos.add(drawLotto());
        }

        return lottos;
    }

    public Lotto drawLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return  new Lotto(numbers);
    }

    public void getWinningResult(){

    }

    public double getProfitRate(){
        double profitRate = 0;

        return profitRate;
    }

    private void validateAmount(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }
}
