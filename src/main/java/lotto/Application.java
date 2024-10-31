package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int[] statistics;

    public static List<Integer> makeLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void printStatistics(){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+statistics[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+statistics[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+statistics[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+statistics[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+statistics[1]+"개");
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());
        if(budget<1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }

        int count = budget/1000;
        System.out.println();
        System.out.println(count+"개를 구매했습니다.");

        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<count;i++){
            lottos.add(new Lotto(makeLotto()));
            System.out.println(lottos.get(i).toString());
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> goalNumbers = new ArrayList<>();
        for (String number : Console.readLine().split(",")) {
            goalNumbers.add(Integer.parseInt(number.trim()));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        statistics = new int[6];
        for(Lotto lotto : lottos){
            int rank = lotto.getRank(goalNumbers,bonusNumber);
            statistics[rank]++;
        }

        printStatistics();
    }
}
