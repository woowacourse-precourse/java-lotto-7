package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PRICE = 100000;

    private int purchaseAmount;
    private int bonusNumber;
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();
    private Lotto lotto;

    public void start() {
        purchaseAmountInput();
        lottoWinningNumberInput();
        lottoBonusNumberInput();
    }

    // 첫 번째 입력(구입 금액)
    private void purchaseAmountInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");

            purchaseAmount = Integer.parseInt(checkPositiveNumber(Console.readLine()));
            checkUnitOfPurchaseAmount(purchaseAmount);
            checkPurchasedAmountExceeded(purchaseAmount);

            LottoIssuance(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmountInput();
        }
    }

    // 두 번째 입력(로또 번호(당첨 번호))
    private void lottoWinningNumberInput() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            List<String> winningNumber = List.of(Console.readLine().split(","));
            List<Integer> winningNumbers = new ArrayList<>();

            for (String number : winningNumber) {
                winningNumbers.add(Integer.parseInt(checkPositiveNumber(number)));
            }

            Collections.sort(winningNumbers);

            lotto = new Lotto(winningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoWinningNumberInput();
        }
    }

    // 세 번째 입력(보너스 번호)
    private void lottoBonusNumberInput() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(checkPositiveNumber(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoBonusNumberInput();
        }
    }


    // 금액에 맞게 로또를 발급하는 메서드
    public void LottoIssuance(int purchaseAmount) {
        int numberOfLottoPurchases = purchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + numberOfLottoPurchases + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLottoPurchases; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoNumbers.add(randomNumbers);
        }

        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    // 100,000원을 초과했는지 확인하는 메서드
    public void checkPurchasedAmountExceeded(int purchaseAmount) {
        if (purchaseAmount > MAX_LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다.");
        }
    }

    // 1,000원 단위인지 확인하는 메서드
    public void checkUnitOfPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 양수인지 확인하는 메서드
    public String checkPositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
        }
        return input;
    }
}
