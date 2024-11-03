package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public interface Input {
    public <T> T input();

    public void validate(String input);

    default String readInput() {
        return Console.readLine();
    }
}
