package io;

import camp.nextstep.edu.missionutils.Console;

/**
 * 입력값을 받는 클래스
 */
public class Input {
    public static final String SPLITTER = ",";
    final String inputString;

    public Input() {
        this.inputString = Console.readLine();
    }

    public String getInput() {
        return this.inputString;
    }
}
