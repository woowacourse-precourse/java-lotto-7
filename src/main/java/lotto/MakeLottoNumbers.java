package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeLottoNumbers {
    public int[] countPrize = new int[6];

    public int[] makeLottoNumber() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>(); // 2차원 리스트 선언
        List<Integer> lotto = new ArrayList<>();
        List<Integer> prize = new ArrayList<>();
        int count = Integer.parseInt(Console.readLine()) / 1000;
        System.out.println(count+"개를 구매했습니다.");

        for (int i = 0; i < count; i++) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 입력받기
            allLottoNumbers.add(lotto); // 입력받은 로또 번호를 2차원 리스트에 추가
            printLottoNumbers(lotto);
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        prize = Lotto.lottoNumber(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        for(int i = 0; i<allLottoNumbers.size(); i++){
            matchLottoNumbers(allLottoNumbers.get(i), lotto, bonus);
        }

        return countPrize;
    }
    private void printLottoNumbers(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i)); // 각 번호 출력
            if (i < lotto.size() - 1) {
                System.out.print(", "); // 마지막 번호 뒤에는 쉼표를 찍지 않음
            }
        }
        System.out.println("]"); // 대괄호 닫기 및 줄 바꿈
    }

    public int[] matchLottoNumbers(List<Integer> numbers, List<Integer> lotto, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for(Integer number : numbers){
            if(lotto.contains(number)){
                count++;
            }
        }
        if(numbers.contains(bonusNumber)) {
            bonus = true;
        }
        countPrizes(countPrize, count, bonus);
        return countPrize;
    }

    public int[] countPrizes(int[] countPrize, int count, boolean bonus){
        first(countPrize, count, bonus);
        bonus(countPrize, count, bonus);
        countPrize[5]++;
        return countPrize;
    }

    public int[] first(int[] countPrize, int count, boolean bonus) {
        if(count == 6){
            countPrize[0]++;
            return countPrize;
        }
        else if(count == 4){
            countPrize[3]++;
            return countPrize;
        }
        else if(count == 3){
            countPrize[4]++;
            return countPrize;
        }
        return countPrize;
    }

    public int[] bonus(int[] countPrize, int count, boolean bonus) {
        if(count == 5&&bonus){
            countPrize[1]++;
            return countPrize;
        }
        else if(count == 5&&!bonus) {
            countPrize[2]++;
        }
        return countPrize;
    }

}
