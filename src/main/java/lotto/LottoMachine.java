package lotto;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    int inputMoney;
    int count;

    ArrayList<Integer> winnigNumbers;

    ArrayList<Lotto> lottoNumbers = new ArrayList<>();

    public LottoMachine(int inputMoney){

        this.inputMoney = inputMoney;

        this.count = this.inputMoney/1000;

    }

    public void makeLottos(){

        for (int i=0;i<this.count;i++){

            this.lottoNumbers.add(new Lotto(Randoms.

                            pickUniqueNumbersInRange(1,45,6)));
        }

    }
    public void printLottos(){
        System.out.println(String.format("%d개를 구매했습니다.",this.count));
        for(int i = 0;i < this.count; i++){
            System.out.println(lottoNumbers.get(i).getNumbers());
        }
    }
}
