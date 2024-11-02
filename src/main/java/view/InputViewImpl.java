package view;

import camp.nextstep.edu.missionutils.Console;
import dto.lottoWinningResultDto.LottoWinningResultRequest;

public class InputViewImpl implements InputView {
    @Override
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();

        return new LottoWinningResultRequest(winningNumbers, bonusNumber);
    }
}
