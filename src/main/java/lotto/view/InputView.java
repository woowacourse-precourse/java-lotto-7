package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    //로또 구입 금액 입력 메소드
    public static int getPurchaseAmount() {
        final int AmountUnit = 1000;

        System.out.println("로또 구입 금액을 입력하십시오(1000원 단위).:");
        String input = Console.readLine();

        int PurchaseAmount =  Integer.parseInt(input);

        if (PurchaseAmount <= 0 || PurchaseAmount % AmountUnit != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위입니다.");
        }

        int LottoAmount = PurchaseAmount / AmountUnit;

        System.out.println(LottoAmount + "개를 구매했습니다.");

        return PurchaseAmount;
    }

    // 당첨 로또 번호 입력
    public static List<Integer> getWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해주세요 (구분은 쉼표로):");
        String input = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)         // 각 요소 공백 제거
                .map(Integer::parseInt)    // 정수로 변환
                .collect(Collectors.toList());

        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1과 45 사이여야 합니다.");
            }
        }

        // 중복된 번호가 있는지 확인하고, 중복 시 예외를 발생
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 번호는 허용되지 않습니다.");
        }
        return winningNumbers;
    }

}
