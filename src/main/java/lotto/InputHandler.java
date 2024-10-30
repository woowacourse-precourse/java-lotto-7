package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public Integer getAmountPaid(){
        String input = Console.readLine();
        isMultipleOfThousand(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public List<Integer> getLottoNumber(){
        String input = Console.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                list.add(Character.getNumericValue(input.charAt(i)));
            }
        }
        return list;

    }
    public int getBonusNumber(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }



    public void isMultipleOfThousand(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException();
        }
    }
    public List<Lotto> initializeLotto(int num){

        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<num;i++){

            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }



}
