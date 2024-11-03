package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getLottoCost(){

        return Integer.parseInt(Console.readLine());
    }

    public String getWinningLotto(){
        return Console.readLine();
    }
}
