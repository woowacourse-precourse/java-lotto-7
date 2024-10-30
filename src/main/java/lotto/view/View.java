package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    private static final String INPUT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String EMPTY_LINE = "";

    public String getUserInput() {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }

    public void printPurchaseMessage(int tickets) {
        System.out.println(EMPTY_LINE);
        System.out.println(tickets + "개를 구매했습니다");
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }


}
