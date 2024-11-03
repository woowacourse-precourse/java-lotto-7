package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    int inputMoney;
    int count;

    List<Integer> winnigNumbers = new ArrayList<>();
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

    public void inputWinnigNumbers(String winnigNumbers){

        int[] intNumbers = covertToInt(winnigNumbers.split(","));
        for(int i=0; i<intNumbers.length;i++){
            this.winnigNumbers.add(intNumbers[i]);
        }

    }

    public void inputBonusNumbers(String bonusNumber){

        this.winnigNumbers.add(Integer.parseInt(bonusNumber));

    }


    private int[] covertToInt(String[] strArr){
        int[] convertedArr = new int[strArr.length];
        for(int i=0; i< strArr.length;i++){
            convertedArr[i] = Integer.parseInt(strArr[i]);
        }
        return convertedArr;
    }


}
