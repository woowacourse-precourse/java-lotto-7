package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoPurchase {
    public int purchaseQuantity;
    public ArrayList<Lotto> purchaseLottoList = new ArrayList<>();

    public void purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountg = Console.readLine();
        validateInput(purchaseAmountg);
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountg);
            purchaseQuantity = purchaseAmount/1000;
            makeNumbers(purchaseQuantity);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 구입금액은 숫자만 입력 가능합니다.");
        }
    }

    public void makeNumbers(int quantity) {
        for (int i=0; i < quantity; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());
            addLottoList(numbers);
        }
    }

    public void addLottoList(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        purchaseLottoList.add(lotto);
    }

    public void printPurchaseLottoList() {
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
        for (Lotto list : purchaseLottoList) {
            System.out.println(list.getNumbers());
        }
    }

    public void validateInput(String str) {
        if (!str.matches("\\d+")) {
            System.out.println("[ERROR] 로또 구입금액은 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 숫자만 입력 가능합니다.");
        }
    }
}
