package lottoWinningNumber;

import camp.nextstep.edu.missionutils.Console;

public class LottoWinningNumberInputter {
    private static final String NOTICE_TO_INPUT_LOTTO_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public String runAndBringInput() {
        noticeInputLottoWinningNumber();
        String lottoWinningNumber = extractInputLottoWinningNumber();

        return lottoWinningNumber;
    }

    private void noticeInputLottoWinningNumber() {
        System.out.println(System.lineSeparator() + NOTICE_TO_INPUT_LOTTO_WINNING_NUMBER);
    }

    private String extractInputLottoWinningNumber() {
        String lottoWinningNumber = Console.readLine();

        return lottoWinningNumber;
    }
}
