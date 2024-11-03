package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
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

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = RandomMaker.getRandomNumbers(NUMBER_COUNT);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] tokens = readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(tokens).map(token -> {
            try {
                return Integer.parseInt(token.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 숫자만 입력해야 합니다.");
            }
        }).toList();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());


    }
}
