package lotto.viewer.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.viewer.Viewer;

public class ViewerImpl implements Viewer {

    public String getInput() {
        return Console.readLine();
    }

    public void printError(Exception e) {
        System.out.println(ERROR_SIGN + e.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
