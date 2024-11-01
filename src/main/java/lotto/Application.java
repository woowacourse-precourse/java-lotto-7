package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();

        int price = inputView.inputPrice();
        int[] winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        System.out.println(price);
        for (int num : winningNumbers) {
            System.out.print(num + ",");
        }
        System.out.print("\n");

        System.out.println(bonusNumber);
    }
}
