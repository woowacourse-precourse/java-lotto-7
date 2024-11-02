package lotto;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
        List<List<Integer>> lottoNumbers = new LinkedList<>();

        for(int i = 0; i < numberOfPurchases; i++){
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        ListIterator<List<Integer>> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new LinkedList<>();

        for(String n:readLine().split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }
    }
}
