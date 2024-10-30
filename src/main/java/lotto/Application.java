package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = Integer.parseInt(Console.readLine());
        System.out.println();

        int lottoCount = lottoPrice / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))));

        lottos.forEach(Lotto::ascNumbers);

        lottos.forEach(System.out::println);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
    }
}
