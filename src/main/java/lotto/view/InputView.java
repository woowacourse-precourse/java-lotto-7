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
import lotto.constant.ErrorMessage;

import java.util.NoSuchElementException;

public class InputView {
    public String readLine() {
        String readLine = Console.readLine();
        return readLine.trim();
    }

    public double readDouble() {
        try {
            String input = Console.readLine();
            return Double.parseDouble(input);
        }catch(Exception e) {
            if (e instanceof NoSuchElementException) {
                throw e;
            }
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
    }
}
