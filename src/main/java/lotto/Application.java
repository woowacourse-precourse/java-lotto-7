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
        int purchasedLottoCnt = amount.getAmount() / 1000;

        // 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
        System.out.println(purchasedLottoCnt + "개를 구매했습니다.");

        for (int i = 0; i < purchasedLottoCnt; i++) {
            List<Integer> numbers = generateUniqueNumbers();
            Lotto lotto = new Lotto(numbers);
            System.out.println(lotto);
        }
    }

    /**
     * 고유한 로또 번호 리스트를 생성한다.
     * 중복된 숫자가 있을 경우, 중복을 제거하고 새로운 숫자를 다시 뽑아 리스트를 채운다.
     *
     * @return 고유한 로또 번호 리스트
     */
    private static List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> uniqueSet = new HashSet<>(numbers);

        while (uniqueSet.size() < 6) {
            int newNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1).get(0);
            uniqueSet.add(newNumber);
        }

        return new ArrayList<>(uniqueSet);
    }
}


