package lotto.lottoMachine.lottoWinningNumber;

import camp.nextstep.edu.missionutils.Console;

public class LottoWinningNumberInputter {
    private static final String NOTICE_TO_INPUT_LOTTO_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String getInput() {
        noticeInputLottoWinningNumber();
        String lottoWinningNumber = extractInputLottoWinningNumber();

        return lottoWinningNumber;
    }

    private void noticeInputLottoWinningNumber() {
        System.out.println(LINE_SEPARATOR + NOTICE_TO_INPUT_LOTTO_WINNING_NUMBER);
    }

    private String extractInputLottoWinningNumber() {
        String lottoWinningNumber = Console.readLine();

        return lottoWinningNumber;
    }
}
