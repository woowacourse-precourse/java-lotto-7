package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class GamePlay {

    private final int LOTTO_MONEY = 1000;
    private int useMoneys;
    private Lotto winningLotto;
    private int bonusNumber;

    public GamePlay() {
        useMoneys = getMoney();
        winningLotto = getWinningLotto();
        bonusNumber = getBonusNumber();
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private Lotto getWinningLotto() {
        System.out.println("당첨 번호 6자리를 입력해주세요. (,) 쉼표를 기준으로 구분됩니다.");

        return new Lotto(stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private int getMoney() {
        System.out.println("로또 구입 금액을 입력해주세요. 단, 1000원 단위로 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money / LOTTO_MONEY;
    }

}
