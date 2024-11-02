package lotto;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    int inputMoney;

    ArrayList<Integer> winnigNumbers;

    ArrayList<Lotto> lottoNumbers = new ArrayList<>();

    public LottoMachine(int inputMoney){
        this.inputMoney = inputMoney;
    }

    public void makeLottos(){
        int count = this.inputMoney/1000;
        for (int i=0;i<count;i++){
            this.lottoNumbers.add(new Lotto(Randoms.
                            pickUniqueNumbersInRange(1,45,6)));
        }

    }
}
