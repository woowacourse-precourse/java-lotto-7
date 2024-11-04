package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {
    public static final int AmountUnit = 1000;
    public static final String LINE_BREAK = "\n";

    //로또 구입 금액 입력 메소드
    public static int getPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력하십시오(1000원 단위).:");
        String input = Console.readLine();

        try {
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount <= 0 || purchaseAmount % AmountUnit != 0) {
                System.out.println("[ERROR] 금액은 1000원 단위입니다.");
                return -1;
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해주세요.");
            return -1;
        }
    }

    // 당첨 로또 번호 입력
    public static List<Integer> getWinLottoNumbers() {
        System.out.println(LINE_BREAK + "당첨 번호를 입력해주세요 (구분은 쉼표로):");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)         // 각 요소 공백 제거
                .map(Integer::parseInt)    // 정수로 변환
                .collect(Collectors.toList());
    }

    // 보너스 번호 입력 받기
    public static int getBonusNumber() {
        System.out.println(LINE_BREAK + "보너스 번호를 입력해주세요: ");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
