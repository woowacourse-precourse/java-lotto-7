package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningView {
    public WinningView() { }

    public String getInput() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winning = Console.readLine();
        return winning;
    }
}