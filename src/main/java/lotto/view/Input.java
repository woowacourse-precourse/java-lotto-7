package lotto.view;

import lotto.viewHandler.Api;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public Api<String> getPurchaseMoney() {

        return new Api<String>();
    }

    private String getInput() {
        return readLine();
    }

    private void closeInput() {
        close();
    }
}
