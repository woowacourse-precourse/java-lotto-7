package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Lotto> lottos = new ArrayList<>();

    public static int stringToNum(String input) {
        try {
            int lotto_cost = Integer.parseInt(input);
            return lotto_cost;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    public static int inputAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int lotto_cost = stringToNum(readLine());
                return lotto_cost;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static int makeLotto(int lotto_cost) {
        for (int i = lotto_cost; i >= 0; i -= 1000) {
            Lotto element;
            element.pickRandNum();
            lottos.add(element);
        }
    }

    public static void buyLotto() {
        int lotto_cost = inputAmount();
        makeLotto(lotto_cost);
        // outputLottoNumbers();
    }

    public static void main(String[] args) {
        buyLotto();
    }
}
