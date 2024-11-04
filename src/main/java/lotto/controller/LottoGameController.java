package lotto.controller;

import static lotto.constants.Constants.DELIMITER;
import static lotto.utils.UnitConverter.convertUnit;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Prizes;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ticket;
import lotto.domain.UserLotto;
import lotto.dto.PublishedLottiesDTO;
import lotto.dto.ResultMarginDTO;
import lotto.dto.UserLottoDTO;
import lotto.dto.UserMoneyDTO;
import lotto.dto.UserSixNumberDTO;
import lotto.service.LottoBowl;
import lotto.service.LottoComparator;
import lotto.service.MarginCalculator;
import lotto.utils.NumberValidator;
import lotto.utils.StringSplitter;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Money;

public class LottoGameController {

    public void run() {
        UserMoneyDTO userMoneyDTO = readUserMoney();
        PublishedLottiesDTO publishedLottiesDTO = generateLottoTicket(userMoneyDTO);

        showRandomLotties(publishedLottiesDTO);

        UserLottoDTO userLottoDTO = getUserLottoSelection();

        ResultMarginDTO resultMarginDTO = calculateResult(publishedLottiesDTO, userLottoDTO, userMoneyDTO);

        showLottoResult(resultMarginDTO);
        Console.close();
    }

    private ResultMarginDTO calculateResult(PublishedLottiesDTO publishedLottiesDTO,
                                            UserLottoDTO userLottoDTO,
                                            UserMoneyDTO userMoneyDTO) {
        LottoComparator lottoComparator = LottoComparator.from(publishedLottiesDTO.getRandomLotties(),
                userLottoDTO.getUserLotto());
        LottoResult lottoResult = LottoResult.initialize();
        lottoComparator.compare(lottoResult);

        MarginCalculator marginCalculator = new MarginCalculator(lottoResult, userMoneyDTO.getUserMoney());
        BigDecimal margin = marginCalculator.calculateMargin();

        return ResultMarginDTO.from(lottoResult, margin);
    }

    private UserLottoDTO getUserLottoSelection() {
        UserSixNumberDTO userSixNumberDTO = readUserSixNumber();
        return readUserLotto(userSixNumberDTO.getUserSixNumber());
    }

    private PublishedLottiesDTO generateLottoTicket(UserMoneyDTO userMoneyDTO) {
        Ticket ticket = Ticket.from(userMoneyDTO.getUserMoney());
        LottoBowl lottoBowl = LottoBowl.from(ticket);

        return PublishedLottiesDTO.from(lottoBowl.publishLotties(), ticket);
    }

    private void showRandomLotties(PublishedLottiesDTO publishedLottiesDTO) {
        OutputView.printLottoCount(publishedLottiesDTO.getPublishedTicket());
        OutputView.printEnter();
        for (Lotto lotto : publishedLottiesDTO.getRandomLotties()) {
            OutputView.printLotto(lotto.getSortedLotto());
        }
        OutputView.printEnter();
    }

    private void showLottoResult(ResultMarginDTO resultMarginDTO) {
        OutputView.printWinningBanner();
        OutputView.printDiviner();

        LottoResult lottoResult = resultMarginDTO.getLottoResult();

        for (Prizes prize : Arrays.stream(Prizes.values()).toList()) {
            OutputView.printWinningResult(
                    prize.getCount(),
                    convertUnit(prize.getMoney()),
                    lottoResult.getResult().get(prize.name()),
                    prize.getComment());
        }

        OutputView.printTotalProfit(convertUnit(resultMarginDTO.getMargin()));
    }

    private UserMoneyDTO readUserMoney() {
        while (true) {
            try {
                OutputView.printInsertMoney();
                String rawUserMoney = InputView.getUserMoney();
                OutputView.printEnter();
                Money userMoney = new Money(Integer.parseInt(rawUserMoney));

                return new UserMoneyDTO(userMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private UserSixNumberDTO readUserSixNumber() {
        while (true) {
            try {
                OutputView.printInsertUserLotto();
                String rawUserLotto = InputView.getUserLotto();
                OutputView.printEnter();
                List<String> splittedRawInput = StringSplitter.splitByDelimiter(rawUserLotto, DELIMITER);
                splittedRawInput.forEach(NumberValidator::validateInt);

                Lotto userSixNumber = new Lotto(splittedRawInput
                        .stream()
                        .map(Integer::parseInt)
                        .toList());

                return new UserSixNumberDTO(userSixNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private UserLottoDTO readUserLotto(Lotto userSixNumber) {
        while (true) {
            try {
                OutputView.printInsertBonus();
                String rawBonus = InputView.getUserBonus();
                OutputView.printEnter();

                UserLotto userLotto = new UserLotto(userSixNumber, Integer.parseInt(rawBonus));

                return new UserLottoDTO(userLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
