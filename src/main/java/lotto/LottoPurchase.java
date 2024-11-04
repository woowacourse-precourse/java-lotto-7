package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoPurchase {
    public int purchaseQuantity;
    public ArrayList<Lotto> purchaseLottoList = new ArrayList<>();

    public void purchase() {
        System.out.println(Constants.INPUT_LOTTO_PURCHASE_AMOUNT);
        String purchaseAmountInput = Console.readLine();
        System.out.println();
        try {
            validateInput(purchaseAmountInput);
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            validateInput(purchaseAmount);
            purchaseQuantity = purchaseAmount / Constants.PRICE_UNIT;
            makeNumbers(purchaseQuantity);
        } catch (IllegalArgumentException e) {
            purchase();
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
        System.out.printf(Constants.PRINT_LOTTO_PURCHASE_QUANTITY + "\n", purchaseQuantity);
        for (Lotto list : purchaseLottoList) {
            System.out.println(list.getNumbers());
        }
        System.out.println();
    }

    public void validateInput(String str) {
        if (!str.matches("\\d+")) {
            System.out.println(Constants.NOT_NUMBER);
            throw new IllegalArgumentException(Constants.NOT_NUMBER);
        }
    }

    public void validateInput(int purchaseAmount) {
        if (purchaseAmount % Constants.PRICE_UNIT != 0 || purchaseAmount == 0) {
            System.out.println(Constants.NOT_PRICE_UNIT);
            throw new IllegalArgumentException(Constants.NOT_PRICE_UNIT);
        }
    }
}
