package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

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
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> winLottoNumbers = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();
        try {
            for (String numStr : input.split(",")) {
                int numbers = Integer.parseInt(numStr.trim());

                // 1 ~ 45 범위 검사
                if (numbers < 1 || numbers > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                // 중복 검사
                if (!numberSet.add(numbers)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자를 뽑아야 합니다.");
                }
                winLottoNumbers.add(numbers);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 포함해야 합니다.");
        }
        Lotto winLotto = new Lotto(winLottoNumbers);
    }
}
