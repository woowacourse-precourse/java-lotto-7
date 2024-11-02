package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        int inputPrice = 0;
        int turn;

        // 로또 구입금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        try {
            inputPrice = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
        }

        // 구매 금액에서 로또 개수 세기
        if ((inputPrice % 1000) != 0) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
        }
        turn = inputPrice / 1000;
        System.out.println(turn + "개를 구매했습니다.");

        // 구매 금액만큼 로또 생성
        for (int i = 0; i < turn; i++) {
            List<Integer> tempLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(tempLotto));
            System.out.println(tempLotto.toString());
        }
    }
}
