package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public static final String REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public void printRequest(String requestMessage){
        System.out.println(requestMessage);
    }
}
