package lotto.viewer;

import camp.nextstep.edu.missionutils.Console;

public class Viewer {

    public static final String ERROR_SIGN = "[ERROR] ";

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
