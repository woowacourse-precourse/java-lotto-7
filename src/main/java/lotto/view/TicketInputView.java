package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ThousandWons;

public class TicketInputView {

    public ThousandWons initialize() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        return ThousandWons.of(money);
    }

}
