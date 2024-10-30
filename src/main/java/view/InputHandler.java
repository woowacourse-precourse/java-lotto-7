package view;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public int getAmountInput(){
        return Integer.parseInt(Console.readLine());
        //문자나 공백이 아닌지 확인
        //1000원으로 나누어서 나머지가 0인지 확인
    }
}
