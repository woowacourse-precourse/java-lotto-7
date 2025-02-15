package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자이므로 void를 붙이지 않고 일반 메서드와 구분한다.
    // 생성자는 객체를 초기화 할 때만 호출된다.
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidate.validateSize(numbers);
        LottoValidate.validateUnique(numbers);
        LottoValidate.validateRange(numbers);
        LottoValidate.validateType(numbers);
    }

    // 구매한 로또의 개수 반환
    public static int lottoCount(int lottoPurchaseAmount){
        return lottoPurchaseAmount / 1000;
    }

    // 랜덤으로 선택된 로또 번호 오름차순 정렬
    public static List<Integer> sortRandomPickPurchaseLottoNumbers(List<Integer> numbers){
        List<Integer> sortNumbers  = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }

    // 로또 번호 랜덤으로 선택
    public static List<Integer> randomPickPurchaseLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 구매한 로또 번호의 리스트들을 반환
    public static List<List<Integer>> purchaseLottoNumbers(int lottoCount){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = randomPickPurchaseLottoNumbers();
            List<Integer> sortNumber =sortRandomPickPurchaseLottoNumbers(numbers);
            lottoNumbers.add(sortNumber);
        }
        return lottoNumbers;
    }

    // 두 리스트의 공통된 번호가 몇개인지 체크
    public int commonValueCount(List<Integer> purchaseLottoNumber){
        return (int) this.numbers.stream()
                .filter(purchaseLottoNumber::contains)
                .count();
    }

    // 번호를 맞춘 개수를 리스트에 반영
    public static void bonusNumberCheck(int[] checkNumber, int count, List<Integer> purchaseLottoNumber,int bonusNumber){
        if (count == 5){
            if (purchaseLottoNumber.contains(bonusNumber)){
                checkNumber[count-2]++;
                return;
            }
            checkNumber[count-3]++;
            return;
        }
        else if (count == 6){
            checkNumber[count-2]++;
            return;
        }
        else if (count == 3 || count == 4){
            checkNumber[count-3]++;
        }
    }

    // 구매한 로또 번호와 당첨 번호 비교
    public static int[] lottoWinningCheck(Lotto lotto, int bonusNumber, List<List<Integer>> purchaseLottoNumbers){
        int[] checkNumber = new int[5];
        for(List<Integer> purchaseLottoNumber : purchaseLottoNumbers){
            int count = lotto.commonValueCount(purchaseLottoNumber);
            bonusNumberCheck(checkNumber, count, purchaseLottoNumber, bonusNumber);
        }
        return checkNumber;
    }
}
