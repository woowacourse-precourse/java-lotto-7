package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int pay = Integer.parseInt(Console.readLine());
        List<Lotto> lottos = new ArrayList<>();

        int count = pay/1000;

        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto( Randoms.pickUniqueNumbersInRange(1,45,6)));
        }

        for (Lotto lotto : lottos) {
            lotto.getLottoNumbers();
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Console.readLine(),",");
        for (int i = 0; i < 6; i++) {
            winningNum.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        int[] result = new int[5];
        int prize = 0;
        for (Lotto lotto : lottos) {
            Rank rank = lotto.read(winningNum, bonus);
            if (rank != null) {
                prize += rank.getAmount();
                result[rank.getSerial() - 1] += 1;
            }
        }

        Rank.print(result);

        double ben = ((double)prize/(double)pay)*100;

        System.out.println("총 수익률은 " + String.format("%.1f", ben) + "%입니다.");
    }
}
