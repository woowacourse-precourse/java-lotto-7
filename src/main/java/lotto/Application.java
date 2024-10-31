package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int money = Input.read(Input::money);

        int N = money / 1000;

        List<Lotto> lottos = new ArrayList<>();

        System.out.println(N + "개를 구매했습니다.");
        for (int i = 0; i < N; i++) {
            Lotto lotto = new Lotto();
            lotto.printNumbers();
            lottos.add(lotto);
        }

    }

}
