package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    /**
     * 사용자들로부터 String으로된 문자열을 입력받는 함수
     * OutputView에서 안내문구를 따로 출력해주기에 입력은 1개의 함수로 REUSE
     * @return String
     */
    public static String getUserInput() {
        return readLine();
    }
}
