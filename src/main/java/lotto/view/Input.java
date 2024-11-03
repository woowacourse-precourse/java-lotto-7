package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public interface Input<T, S> {
    public T input();

    public void validate(S input);

    default String readInput() {
        return Console.readLine().trim();
    }
}
