package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoMachine {

    Lotto winningLotto;
    List<Integer> winningNum;
    int pay;
    int prize = 0;
    int bonus;
    DecimalFormat formatter = new DecimalFormat("###,###");

    public int validateMoney(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.");
            }
        }
        return Integer.parseInt(str);
    }

    public void enterPay() {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            String str = Console.readLine();
            pay = validateMoney(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterPay();
        }
    }

    public List<Lotto> buyLotto() {

        List<Lotto> lottos = new ArrayList<>();

        int count = pay/1000;

        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto( Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }

    public void setWinningNum() {

        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
            winningNum = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                winningNum.add(Integer.parseInt(st.nextToken()));
            }

            winningLotto = new Lotto(winningNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNum();
        }

    }

    public void setBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
    }

    public void checkResult(List<Lotto> lottos) {

        int[] result = new int[5];
        for (Lotto lotto : lottos) {
            Rank rank = lotto.read(winningNum, bonus);
            if (rank != null) {
                prize += rank.getAmount();
                result[rank.getSerial() - 1] += 1;
            }
        }
        print(result);
    }

    public void printBenefitRate() {
        double ben = ((double)prize/(double)pay)*100;

        System.out.println("총 수익률은 " + String.format("%.1f", ben) + "%입니다.");
    }

    public void print(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");
        for (int i = 4; i >=0 ; i--) {
            sb.append(Rank.ranks[i].getMatch());
            sb.append("개 일치");
            if(i == 1) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (");
            sb.append(formatter.format(Rank.ranks[i].getAmount()));
            sb.append("원) - ");
            sb.append(result[i]);
            sb.append("개\n");
        }
        System.out.println(sb);
    }


}
