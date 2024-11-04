package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getPurchaseAmount() {
        int purchaseAmount;
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            purchaseAmount = Integer.parseInt(Console.readLine());

            // 유효성 검사: 구입 금액이 1,000 이상인지 확인
            if (purchaseAmount < 1000) {
                throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원 이상입니다.");
            }
        } catch (NumberFormatException e) {
            // 숫자가 아닌 입력에 대한 예외 처리
            System.out.println("[ERROR] 입력한 금액이 유효하지 않습니다. 숫자만 입력해 주세요.");
            return getPurchaseAmount(); // 잘못된 입력 시 재귀 호출
        } catch (IllegalArgumentException e) {
            // 유효하지 않은 금액에 대한 예외 처리
            System.out.println(e.getMessage());
            return getPurchaseAmount(); // 유효하지 않은 입력 시 재귀 호출
        }
        return purchaseAmount; // 유효한 입력 시 금액 반환
    }

    public static WinningLotto getWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해주세요.");

        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(winningNumbers,bonusNumber);
    }
}
