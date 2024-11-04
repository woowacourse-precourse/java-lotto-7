package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        String lottoValue;
        Integer lottoLen;
        ArrayList<Lotto> LottoList = new ArrayList<>();
        String tmpWinNumber;
        List<Integer> winNumbers = new ArrayList<>();
        Integer bonusNumber;
        int[] winStatus = new int[5];

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                lottoValue = Console.readLine();


                lottoLen = Integer.parseInt(lottoValue);
                if ((lottoLen % 1000) != 0) {
                    new IllegalArgumentException("[ERROR] 로또 구입 값은 1000원 단위로만 받을 수 있습니다.");
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoLen = lottoLen / 1000;
        System.out.println();
        System.out.println(lottoLen+"개를 구매했습니다.");

        for(int i = 0; i < lottoLen; i++){
            List<Integer> newPick = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            newPick.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(newPick);
            LottoList.add(lotto);
        }

        for (Lotto list : LottoList){
            System.out.println(list.getNumbers());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        tmpWinNumber = Console.readLine();

        Arrays.stream(tmpWinNumber.split(","))
                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // Integer로 변환
                .forEach(winNumbers::add); // List에 추가

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");


        for (Lotto list: LottoList){
            Integer count=0;
            for (Integer target : winNumbers){
                if (list.contains(target)){
                    count++;
                }

                if (count==5){
                    if (list.contains(bonusNumber)){
                        count=7;
                    }
                }
            }
            if (count==3){
                winStatus[0]+=1;
            }
            if (count==4){
                winStatus[1]+=1;
            }
            if (count==5){
                winStatus[2]+=1;
            }
            if (count==7){
                winStatus[3]+=1;
            }
            if (count==6){
                winStatus[4]+=1;
            }

        }
        Integer sum=0;
        for(int i=0; i<5; i++){
            if (i ==0){
                System.out.println("3개 일치 (5,000원) - "+winStatus[0]+"개");
                sum +=(5000*winStatus[0]);
            }
            if (i ==1){
                System.out.println("4개 일치 (50,000원) - "+winStatus[1]+"개");
                sum +=(50000*winStatus[1]);
            }
            if (i ==2){
                System.out.println("5개 일치 (1,500,000원) - "+winStatus[2]+"개");
                sum +=(1500000*winStatus[2]);
            }
            if (i ==3){
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winStatus[3]+"개");
                sum +=(30000000*winStatus[3]);
            }
            if (i ==4){
                System.out.println("6개 일치 (2,000,000,000원) - "+winStatus[4]+"개");
                sum +=(2000000000*winStatus[4]);
            }
        }

        double profitRate = ((double) sum / Integer.parseInt(lottoValue)) * 100;
        System.out.println("총 수익률은 "+String.format("%.1f",profitRate)+"%입니다.");








    }
}
