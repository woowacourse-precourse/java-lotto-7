package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String getInput(){
        return Console.readLine();
    }
    public void closeInput(){
        Console.close();
    }

}
