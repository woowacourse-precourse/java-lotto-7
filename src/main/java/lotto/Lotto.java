package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(notDuplicateNum(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현

    private boolean notDuplicateNum(List<Integer> numbers){
        Set<Integer> seenNumbers = new HashSet<>();

        for(Integer num : numbers){
            if(!seenNumbers.add(num)){
                return true;
            }
        }
        return false;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<List<Integer>> generatePurchaseLotto(int toPurchaseSize) {

        List<List<Integer>> purchaseLottos = new ArrayList<>(List.of());
        for (int i = 0; i < toPurchaseSize; i++) {
            List<Integer> LottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            sortNumbers(LottoNumbers);
            purchaseLottos.add(LottoNumbers);
        }
        return purchaseLottos;
    }

    public static void sortNumbers(List<Integer> LottoNumbers){
        Collections.sort(LottoNumbers);
    }

    public static void printPurchaseLotto(List<List<Integer>> purchaseLotto) {
        int purchasedsize = purchaseLotto.size();
        System.out.println(purchasedsize + "개를 구매했습니다.\n");
        purchaseLotto.forEach(Lotto::printLottoNum);
    }

    public static void printLottoNum(List<Integer> lottoNum) {
        System.out.print("[");
        for (int i = 0; i < lottoNum.size(); i++) {
            System.out.print(lottoNum.get(i));
            if (i != lottoNum.size() - 1) System.out.print(", ");
        }
        System.out.print("]\n");
    }

}
