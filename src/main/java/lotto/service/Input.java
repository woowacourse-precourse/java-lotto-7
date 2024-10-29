package lotto.service;

import java.util.List;

public class Input {
    /*
    public List<Integer> inputLottoNum(String input){

    }

    public List<Integer> convertToList(String input){
        String[] numList = input.split(",");
    }
    */
    public boolean checkRange(String s){
        int num = Integer.parseInt(s);
        if(num<1 || num>45) throw new IllegalArgumentException("숫자 범위 초과");
        return true;
    }


    public int convertToMoney(String s){
            checkMoney(s);
            return Integer.parseInt(s);
    }

    public void checkMoney(String s){
        checkNum(s);
        int money = Integer.parseInt(s);
        if(money%1000 != 0) throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않음.");
    }

    public void checkNum(String s){
        if (!s.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException("입력이 숫자가 아님");
    }
}
