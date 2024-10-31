package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchase {
    public int purchaseQuantity;
    public ArrayList<List<Integer>> purchaseLottoList = new ArrayList<>();

    public void purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        purchaseQuantity = purchaseAmount/1000;
        makeNumbers(purchaseQuantity);
    }

    public void makeNumbers(int quantity) {
        for (int i=0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            addLottoList(numbers);
        }
    }

    public void addLottoList(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        purchaseLottoList.add(lotto.getNumbers());
    }

    public void printPurchaseLottoList() {
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
        for (List<Integer> list : purchaseLottoList) {
            System.out.println(list);
        }
    }
}
