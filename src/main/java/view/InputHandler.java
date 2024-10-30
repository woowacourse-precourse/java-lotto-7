package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public int getAmountInput(){
        return Integer.parseInt(Console.readLine());
        //문자나 공백이 아닌지 확인
        //1000원으로 나누어서 나머지가 0인지 확인
    }
    public List<Integer> getLottoNumber(){
        String stringNumbers = Console.readLine();
        String[] splitNumbers = stringNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String number : splitNumbers){
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
        //숫자랑 쉼표만 입력했는지 확인
        //숫자가 총 6개인지 확인
        //숫자가 중복이 없는지 확인
    }
    public int getBonusNumber(){
        String stringBonusNumber = Console.readLine();
        return Integer.parseInt(stringBonusNumber);
    }
}
