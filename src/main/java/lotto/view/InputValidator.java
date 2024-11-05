package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class InputValidator {
    private Input input = new Input();

    public int readBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return input.readLottoAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto readWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return new Lotto(input.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void makeBonusNumber(Lotto winningLotto) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                new BonusNumber(input.readBonusNumber(), winningLotto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
