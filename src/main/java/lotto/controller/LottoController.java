package lotto.controller;

import lotto.application.LottoTicketsDto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void run() {
        int userMoney = readUserMoney();
        LottoTicketsDto lottoTicketsDto = lottoService.createLottoTickets(userMoney);
        printLottoTickets(lottoTicketsDto);

        List<Rank> userRanks = calculateUserLottoTicketsRank(lottoTicketsDto);
        printUserRanks(userRanks);

        printRateOfReturn(lottoService.calculateRateOfReturn(userMoney, userRanks));
    }

    private List<Rank> calculateUserLottoTicketsRank(LottoTicketsDto lottoTicketsDto) {
        List<Integer> winningLottoNumbers;
        int bonusNumber;
        List<Rank> userRanks;
        while (true) {
            try {
                winningLottoNumbers = readWinningLotto();
                bonusNumber = readBonusNumber();
                validateDuplicationOfLottoNumber(winningLottoNumbers, bonusNumber);
                userRanks = lottoService.calculateRank(lottoTicketsDto, winningLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userRanks;
    }

    private int readUserMoney() {
        int userMoney;
        while (true) {
            try {
                userMoney = InputView.readUserMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userMoney;
    }

    private void validateDuplicationOfLottoNumber(List<Integer> winningLottoNumbers, int bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 기본 당첨 숫자와 보너스 숫자가 중복됩니다.");
        }
    }
}
