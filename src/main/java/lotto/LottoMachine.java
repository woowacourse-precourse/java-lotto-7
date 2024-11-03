package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoMachine {

    List<Integer> winningNum;
    int bonus;

    public int checkMoney(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                System.out.println("[ERROR] 금액은 숫자로 입력해주세요.");
                return 0;
            }
        }
        return Integer.parseInt(str);
    }

    public List<Lotto> buyLotto(int pay) {

        List<Lotto> lottos = new ArrayList<>();

        int count = pay/1000;

        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto( Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }

    public void setWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Console.readLine(),",");
        for (int i = 0; i < 6; i++) {
            winningNum.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
    }

    public int checkResult(List<Lotto> lottos) {

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
        return prize;
    }

    public void printBenefitRate(int pay, int prize) {
        double ben = ((double)prize/(double)pay)*100;

        System.out.println("총 수익률은 " + String.format("%.1f", ben) + "%입니다.");
    }


}
