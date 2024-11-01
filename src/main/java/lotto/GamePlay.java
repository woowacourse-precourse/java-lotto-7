package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GamePlay {

    private final int LOTTO_MONEY = 1000;
    private int useMoneys;

    public GamePlay() {
        System.out.println("로또 구입 금액을 입력해주세요. 단, 1000원 단위로 입력해주세요.");
        useMoneys = getMoney();
    }

    private int getMoney() {
        int money = Integer.parseInt(Console.readLine());
        return money / LOTTO_MONEY;
    }

}
