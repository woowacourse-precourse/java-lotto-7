/*
 * 클래스 이름 InputView
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readLine() {
        String readLine = Console.readLine();
        return readLine.trim();
    }
}
