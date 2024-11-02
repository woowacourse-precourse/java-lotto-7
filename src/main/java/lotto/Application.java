package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money;
        int lottoCount;
        List<Lotto> lottos = new ArrayList<>();

        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }

        if (money % LOTTO_PRICE == 0) {
            lottoCount = money / LOTTO_PRICE;
        } else {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나눠 떨어지는 값을 입력해야 합니다.");
        }
    }
}
