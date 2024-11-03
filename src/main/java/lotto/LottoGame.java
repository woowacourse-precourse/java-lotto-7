package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    // 1. 구입 금액 입력 및 검증
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 2. 로또 발행 및 출력
    public void purchaseLottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 생성
            lottos.add(new Lotto(numbers)); // 생성된 번호 리스트로 Lotto 객체 생성
        }
        System.out.printf("%d개를 구매했습니다.%n", quantity);
        printLottoNumbers();
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 3. 당첨 번호 및 보너스 번호 입력 및 검증
    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = parseAndValidate(Console.readLine());
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber();
    }

    private List<Integer> parseAndValidate(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
        return numbers;
    }

    private void validateBonusNumber() {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    // 4. 당첨 결과 계산
    private int calculateMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int getRank(List<Integer> lottoNumbers) {
        int matchCount = calculateMatchCount(lottoNumbers);
        if (matchCount == 6) return 1;
        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0; // 미당첨
    }
}
