package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumberView {

    public static String getInput(String question) {
        System.out.println(question);
        return readLine();
    }
}
