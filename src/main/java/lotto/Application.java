package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    // 1. 프로그램 시작 및 예외 처리 루프
    public static void main(String[] args) {
        while (true) {
            try {
                run();
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }










 
}
