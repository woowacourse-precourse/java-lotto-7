package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoProcess();
        }
    }

    public static void lottoProcess() {
        // 1. 로또 구입금액을 입력받고 예외처리한다
        PurchaseAmount amount = UserInputConsole.readPurchaseAmount();
        int purchasedLottoCnt = amount.amount() / 1000;

        // 2. 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
        System.out.println(purchasedLottoCnt + "개를 구매했습니다.");

        for (int i = 0; i < purchasedLottoCnt; i++) {
            List<Integer> numbers = generateUniqueNumbers();
            Lotto lotto = new Lotto(numbers);
            System.out.println(lotto);
        }

        // 3. 로또 당첨 번호를 입력 받는다.
        Lotto lottoWinningNumbers = UserInputConsole.readLottoWinningNumber();

        // 4. 보너스 번호를 입력 받는다.
        int bonusNumber = UserInputConsole.readBonusNumber(lottoWinningNumbers);
    }

    private static List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> uniqueSet = new HashSet<>(numbers);

        while (uniqueSet.size() < 6) {
            int newNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1).getFirst();
            uniqueSet.add(newNumber);
        }
        return new ArrayList<>(uniqueSet);
    }
}
