package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // 로또 번호 랜덤으로 선택
    public static List<Integer> randomPickPurchaseLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 구매한 로또 번호의 리스트들을 반환
    public static List<List<Integer>> purchaseLottoNumbers(int lottoCount){
        List<List<Integer>> lottoNumbers = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(randomPickPurchaseLottoNumbers());
        }
        return lottoNumbers;
    }
}
