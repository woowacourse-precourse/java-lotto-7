package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(readLine());
        int numberOfPurchases = purchasePrice / 1000;

        if(purchasePrice % 1000 != 0){
            // 예외 처리
        }
        System.out.println("\n" + numberOfPurchases + "개를 구매했습니다.");
        List<Lotto> lottoNumbers = new LinkedList<>();

        // 로또 번호 생성 및 리스트에 추가
        for(int i = 0; i < numberOfPurchases; i++){
            Lotto pickedNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            pickedNumbers.sortNumbers();
            lottoNumbers.add(pickedNumbers);
        }

        // 로또 번호 출력
        ListIterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            iterator.next().printNumbers();
        }

        // 당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new LinkedList<>();

        // 당첨 번호 리스트에 추가
        for(String n:readLine().split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }

        // 보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());

        // 겹치는 번호 개수
        List<Integer> countRetain = new LinkedList<>();
        int countHasBonusNumber = 0;
        iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            Lotto currentNumeberList = iterator.next();
            int count = currentNumeberList.getRetainAllSize(winningNumbers);

            if(count == 5 && currentNumeberList.hasBonusNumber(bonusNumber)){

                countHasBonusNumber++;
            }
            else{
                countRetain.add(count);
            }
        }

        int count;
        double statistics = 0;
        System.out.println("\n당첨 통계\n---");

        count = Collections.frequency(countRetain, 3);
        statistics += count * 5000;
        System.out.println("3개 일치 (5,000원) - " + count + "개");

        count = Collections.frequency(countRetain, 4);
        statistics += count * 50000;
        System.out.println("4개 일치 (50,000원) - " + count + "개");

        count = Collections.frequency(countRetain, 5);
        statistics += count * 1500000;
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");

        statistics += countHasBonusNumber * 30000000;
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countHasBonusNumber + "개");

        count = Collections.frequency(countRetain, 6);
        statistics += count * 2000000000;
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");

        statistics = statistics / purchasePrice * 100;
        System.out.println("총 수익률은 " + statistics + "%입니다.");
    }
}
