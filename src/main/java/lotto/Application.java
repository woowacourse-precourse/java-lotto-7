package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int totalLotto = Integer.parseInt(Console.readLine());
        if(totalLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
        System.out.println();

        int cntLotto = totalLotto / 1000;
        System.out.println(cntLotto + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cntLotto; i++) {
            Lotto randLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45, 6));
            lottos.add(randLotto);
            System.out.println(randLotto.toString());
        }
    }
}
