package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자이므로 void를 붙이지 않고 일반 메서드와 구분한다.
    // 생성자는 객체를 초기화 할 때만 호출된다.
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatesCheck(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;

    }

    // 로또 번호 길이 체크
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 중복 체크
    private void duplicatesCheck(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // 로또 번호 범위 체크
    private void rangeCheck(List<Integer> numbers) {
        for (int number:numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이어야 합니다.");
            }
        }
    }

    // 구매한 로또의 개수 반환
    public static int lottoCount(int lottoPurchaseAmount){
        return lottoPurchaseAmount / 1000;
    }

    // 랜덤으로 선택된 로또 번호 오름차순 정렬
    public static void SortRandomPickPurchaseLottoNumbers(List<Integer> numbers){
        Collections.sort(numbers);
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
            SortRandomPickPurchaseLottoNumbers(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    // 두 리스트의 공통된 번호가 몇개인지 체크
    public int commonValueCount(List<Integer> purchaseLottoNumber){
        return (int) this.numbers.stream()
                .filter(purchaseLottoNumber::contains)
                .count();
    }

    // 구매한 로또 번호와 당첨 번호 비교
    public static int[] lottoWinningCheck(Lotto lotto, int bonusNumber, List<List<Integer>> purchaseLottoNumbers){
        int[] checkNumber = new int[5];
        for(List<Integer> purchaseLottoNumber : purchaseLottoNumbers){
            int count = lotto.commonValueCount(purchaseLottoNumber);
        }
    }

}
