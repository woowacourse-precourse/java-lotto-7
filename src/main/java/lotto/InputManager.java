package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Collections;

public class InputManager {
    String input;
    List<String> lottoNumber;

    public void input(){
        input = readLine();
    }

    public int stringToInt(){
        return Integer.parseInt(input);
    }

    private void split(){
        lottoNumber = Arrays.asList(input.split(","));
    }

    public List<Integer> stringToInt_list(){
        split();
        List<Integer> lottoNumbers_int= new ArrayList<>();
        for (String number : lottoNumber){
            positiveValidate(number);
            lottoNumberRangeValidate(Integer.parseInt(number));
            redundancyValidate(lottoNumber,number);
            lottoNumbers_int.add(Integer.parseInt(number));
        }
        return lottoNumbers_int;
    }

    private  void positiveValidate(String input){
        if(!Pattern.matches("^[1-9][0-9]*$",input)){
            throw new IllegalArgumentException("[ERROR] 입력한 수가 양수가 아닙니다.");
        }
    }

    private void lottoNumberRangeValidate(int input){
        if(input<1||input>45){
            throw new IllegalArgumentException("[ERROR] 1-45 사이의 숫자를 입력하세요.");
        }
    }

    private void  redundancyValidate(List<String> lotto, String number){
        if(Collections.frequency(lotto, number)!=1){
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }

    }

    private void  bonusRedundancyValidate(List<String> lotto, String number){
        if(Collections.frequency(lotto, number)!=0){
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }

    }

    public boolean amountInputValidate(){
        try {
            positiveValidate(input);
            int amount =  Integer.parseInt(input);
            if (amount < 1000 || amount%1000!=0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액이 1000의 배수가 아닙니다.");
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean lottoInputValidate(){
        try {
            List<Integer> lotto =  stringToInt_list();
            if (lotto.size()!=6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean bonusInputValidate(){
        try {
            positiveValidate(input);
            lottoNumberRangeValidate(Integer.parseInt(input));
            bonusRedundancyValidate(lottoNumber,input);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
