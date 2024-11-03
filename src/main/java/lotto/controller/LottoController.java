package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    LottoInputView lottoInputView;
    LottoOutputView lottoOutputView;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void run() {
        // 로또 구입 금액 입력받기
        int money = executeWithRetry(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String amount = Console.readLine();
            validateAmount(amount);
            return Integer.parseInt(amount);
        });
        System.out.println(money);
        // 구입한 개수만큼 로또 발행

        // 발행한 로또 수량 및 번호 출력

        // 당첨 번호 입력 받기

        // 보너스 번호 입력 받기

        // 구매한 로또와 당첨 번호 비교

        // 당첨 내역 출력

        // 수익률 출력
    }

    private <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    void validateAmount(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException("빈 칸은 입력할 수 없습니다.");
        }
        int intAmount = Integer.parseInt(amount);
        if (intAmount % 1000 != 0 || intAmount == 0) {
            throw new IllegalArgumentException("로또 금액은 1,000 단위로 입력해주세요.");
        }
    }
}
