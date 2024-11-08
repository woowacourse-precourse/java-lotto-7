package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoReader {

    Lotto winningLotto;
    List<Integer> winningNum;
    int bonus;
    DecimalFormat formatter = new DecimalFormat("###,###");

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

    public void checkResult(Customer customer) {

        int[] result = new int[5];
        int prize = 0;
        for (Lotto lotto : customer.myLotto) {
            Rank rank = lotto.read(winningNum, bonus);
            if (rank != null) {
                prize += rank.getAmount();
                result[rank.getSerial() - 1] += 1;
            }
        }
        print(result);
        customer.prize = prize;
    }

    public void printBenefitRate(Customer customer) {
        double prize = customer.prize;
        double pay = customer.count*1000;

        double ben = (prize/pay)*100;

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
