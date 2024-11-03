package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Lotto> lottos = new ArrayList<>();

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int lotto_cost = Integer.parseInt(readLine());
        return lotto_cost;
    }

    public static void buyLotto() {
        int lotto_cost = inputAmount();
        makeLotto(lotto_cost);
        outputLottoNumbers();
    }

    public static void main(String[] args) {
        buyLotto();
    }
}
