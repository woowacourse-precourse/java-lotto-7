package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public String getUserInput(){
        return Console.readLine();
    }

    public void showMessage(String message){
        System.out.println(message);
    }

}
