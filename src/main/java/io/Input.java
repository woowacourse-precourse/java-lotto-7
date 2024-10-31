package io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    final String inputString;

    public Input() {
        this.inputString = Console.readLine();
    }

    public Input(String string) {
        this.inputString = string;
    }

    public String getInput() {
        return this.inputString;
    }
}
