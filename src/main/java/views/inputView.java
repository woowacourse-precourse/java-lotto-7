package views;

import camp.nextstep.edu.missionutils.Console;

public class inputView {

    public enum promptForInput {
        Purchase("구입금액을 입력해 주세요."),
        LottoNumbers("당첨 번호를 입력해 주세요."),
        BonusNumber("보너스 번호를 입력해 주세요.")
        ;

        private final String prompt;

        promptForInput(String prompt) {
            this.prompt = prompt;
        }

        public String getPrompt() {
            return prompt;
        }
    }

    public String requestUserInput(promptForInput prompt) {
        System.out.println(prompt.getPrompt());
        return Console.readLine();
    }
}
