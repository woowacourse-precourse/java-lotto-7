package lotto.service;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR]";


    public Lotto inputLottoNum(String input){
        List<Integer> lottoNum = convertToList(input);
        lottoNum.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNum);
        return lotto;
    }

    public List<Integer> convertToList(String input){
        String[] numList = input.split(",");

        if(numList.length != 6) throw new IllegalArgumentException(ERROR_MESSAGE+" 숫자 개수가 맞지 않습니다.");

        List<Integer> lottoNum  = new ArrayList<Integer>();
        for(String s : numList){
            checkNum(s);
            checkRange(s);
            lottoNum.add(Integer.parseInt(s));
        }
        return lottoNum;
    }

    public boolean checkRange(String s){
        int num = Integer.parseInt(s);
        if(num<1 || num>45) throw new IllegalArgumentException(ERROR_MESSAGE+" 숫자 범위 초과");
        return true;
    }


    public int convertToMoney(String s){
            checkMoney(s);
            return Integer.parseInt(s);
    }

    public void checkMoney(String s){
        checkNum(s);
        int money = Integer.parseInt(s);
        if(money%1000 != 0) throw new IllegalArgumentException(ERROR_MESSAGE+" 1000원으로 나누어 떨어지지 않음.");
    }

    public void checkNum(String s){
        if (!s.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException(ERROR_MESSAGE+" 입력이 숫자가 아님");
    }

    public int cehckBonusNum(String s,Lotto winningNum){
        checkNum(s);
        checkRange(s);
        int bonusNum = Integer.parseInt(s);
        for(Integer num : winningNum.getNumbers()){
            if(bonusNum == num) throw new IllegalArgumentException(ERROR_MESSAGE+" 보너스 숫자 중복");
        }
        return Integer.parseInt(s);
    }
}
