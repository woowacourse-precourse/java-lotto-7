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

        // 빈 입력 체크
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해야 합니다.");
        }

        // 쉼표로 시작하는 경우
        if (input.startsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 번호는 쉼표로 시작할 수 없습니다.");
        }

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)         // 각 요소 공백 제거
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERROR] 유효한 정수를 입력해야 합니다: " + s);
                    }
                })
                .collect(Collectors.toList());

        // 로또 번호가 6개가 아니거나 중복되는 경우 추가 검증
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        return numbers;
    }

    // 보너스 번호 입력 받기
    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해주세요: ");
        String input = Console.readLine();

        try {
            int bonusNumber = Integer.parseInt(input.trim());
            if (!isBonusNumberValid(bonusNumber, winningNumbers)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 정수를 입력해주세요.");
        }
    }

    private static boolean isBonusNumberValid(int bonusNumber, List<Integer> winningNumbers) {
        return bonusNumber > 0 && bonusNumber <= 45 && !winningNumbers.contains(bonusNumber);
    }
}
