package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    public void isMultipleOfThousand(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException();
        }
    }



}
