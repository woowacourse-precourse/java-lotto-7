package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        String inputWinningNumber = Console.readLine();
        int inputBonusNumber = Integer.parseInt(Console.readLine());

        setAmount(inputPurchaseAmount);

        List<Integer> lottoNumbers = Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = new Lotto(lottoNumbers);




    }

    public static void setAmount(int inputPurchaseAmount) {
        if (inputPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입가능합니다.");
        }
    }
}
