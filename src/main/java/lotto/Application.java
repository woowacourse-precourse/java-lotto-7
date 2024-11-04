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
                if (lottoLen % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 값은 1000원 단위로만 받을 수 있습니다.");
                }

                break;  // 유효한 값이 입력되면 반복문 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자 형식이어야 합니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        lottoLen = lottoLen / 1000;
        System.out.println();
        System.out.println(lottoLen+"개를 구매했습니다.");

        for(int i = 0; i < lottoLen; i++){
            try {
                List<Integer> newPick = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                newPick.sort(Comparator.naturalOrder());
                Lotto lotto = new Lotto(newPick);  // Lotto 생성 시 예외 발생 가능
                LottoList.add(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // 예외 발생 시 해당 로또 재생성
            }
        }

        for (Lotto list : LottoList){
            System.out.println(list.getNumbers());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        tmpWinNumber = Console.readLine();

        try {
            Arrays.stream(tmpWinNumber.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .forEach(winNumbers::add);
            if (winNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자 형식이어야 합니다.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자 형식이어야 합니다.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

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
