package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public enum promptForInput {
        Purchase("구입금액을 입력해 주세요."),
        LottoNumbers("당첨 번호를 입력해 주세요."),
        BonusNumber("보너스 번호를 입력해 주세요.")
        ;

        private final String inputPrompt;

        promptForInput(String inputPrompt) {
            this.inputPrompt = inputPrompt;
        }

        public String getInputPrompt() {
            return inputPrompt;
        }
    }

    public String requestUserInput(promptForInput prompt) {
        System.out.println(prompt.getInputPrompt());
        return Console.readLine();
    }
}
