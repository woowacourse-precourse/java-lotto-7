package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import lotto.controller.LottoController;

public class InputView {
    private final LottoController controller;

    public InputView() {
        controller = new LottoController();
    }

    // 공통 입력 처리 메서드
    private void inputWithRetry(String message, Consumer<String> consumer) {
        System.out.println(message);
        while (true) {
            try {
                String input = Console.readLine().trim();
                consumer.accept(input);  // 입력값을 Consumer로 처리
                break; // 성공적으로 처리된 경우 반복 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public void inputPrice() {
        inputWithRetry("구입금액을 입력해 주세요.", input -> {
            int price = Integer.parseInt(input);
            controller.createLottoNumber(price);
        });
    }

    public void inputNumber() {
        inputWithRetry("당첨 번호를 입력해 주세요.", controller::createWinningNumber);
    }

    public void inputBonusNumber() {
        inputWithRetry("보너스 번호를 입력해 주세요.", controller::createBonusNumber);
    }
}
