package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class GamePlay {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    private List<Lotto> lottos = new ArrayList<>();
    private int useMoneys;
    private Lotto winningLotto;
    private int bonusNumber;

    public GamePlay() {
        useMoneys = getMoney();
        buyLotto();
        winningLotto = getWinningLotto();
        bonusNumber = getBonusNumber();
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private Lotto getWinningLotto() {
        System.out.println("당첨 번호 6자리를 입력해주세요. (,) 쉼표를 기준으로 구분됩니다.");

        return new Lotto(stream(Console.readLine().split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private int getMoney() {
        System.out.println("로또 구입 금액을 입력해주세요. 단, 1000원 단위로 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    private void buyLotto() {
        for(int i=0; i<useMoneys / LOTTO_PRICE; i++){
            lottos.add(pickLotto());
        }

    }

    private Lotto pickLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }


}
