package lotto.viewer;

import camp.nextstep.edu.missionutils.Console;

public class Viewer {

    public String getInput() {
        return Console.readLine();
    }

    public void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


}
