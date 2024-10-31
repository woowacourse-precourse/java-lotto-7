package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {

        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("처리 불가능한 입력입니다!");
        } finally {
            Console.close();
        }
    }
}
