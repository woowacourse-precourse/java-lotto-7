package lotto.controller;

import static lotto.utils.UnitConverter.convertUnit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Prizes;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ticket;
import lotto.domain.UserLotto;
import lotto.dto.UserLottoDTO;
import lotto.dto.UserMoneyTicketDTO;
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
        UserMoneyTicketDTO userMoneyTicketDTO = userMoneyController();
        // -------------------------------------------------------- 위까지 유저 돈, 티켓 정리 UserInfoDTO
        Ticket ticket = userMoneyTicketDTO.getPublishedTicket();
        LottoBowl lottoBowl = LottoBowl.from(ticket);
        Lotties RandomLotties = lottoBowl.publishLotties();

        OutputView.printLottoCount(ticket.getTicket());
        OutputView.printEnter();
        for (Lotto lotto : RandomLotties.getLotties()) {
            OutputView.printLotto(lotto.getLotto());
        }
        OutputView.printEnter();
        // -------------------------------------------------------- 위까지 출력부분

        UserSixNumberDTO userSixNumberDTO = userSixNumberController();

        // -------------------------------------------------------- 위까지 유저가 입력한 로또 UserLottoDTO
        UserLottoDTO userLottoDTO = userLottoController(userSixNumberDTO.getUserSixNumber());

        // -------------------------------------------------------- 위까지 유저가 입력한 보너스 넘버 UserBonusDTO
        UserLotto userLotto = userLottoDTO.getUserLotto();
        Money userMoney = userMoneyTicketDTO.getUserMoney();

        LottoComparator lottoComparator = LottoComparator.from(RandomLotties, userLotto);
        LottoResult lottoResult = LottoResult.initialize();

        lottoComparator.compare(lottoResult);
        MarginCalculator marginCalculator = new MarginCalculator(lottoResult, userMoney);

        BigDecimal margin = marginCalculator.calculateMargin();

        OutputView.printWinningBanner();
        OutputView.printDiviner();

        for (Prizes prize : Arrays.stream(Prizes.values()).toList()) {
            OutputView.printWinningResult(
                    prize.getCount(),
                    convertUnit(prize.getMoney()),
                    lottoResult.getResult().get(prize.name()),
                    prize.getComment());
        }

        OutputView.printTotalProfit(convertUnit(margin));
    }

    private UserMoneyTicketDTO userMoneyController() {
        while (true) {
            try {
                OutputView.printInsertMoney();
                String rawUserMoney = InputView.getUserMoney();
                OutputView.printEnter();

                Money userMoney = new Money(Integer.parseInt(rawUserMoney));
                Ticket ticket = Ticket.from(userMoney);
                return new UserMoneyTicketDTO(userMoney, ticket);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private UserSixNumberDTO userSixNumberController() {
        while (true) {
            try {
                OutputView.printInsertUserLotto();
                String rawUserLotto = InputView.getUserLotto();
                OutputView.printEnter();
                List<String> splittedRawInput = StringSplitter.splitByDelimiter(rawUserLotto, ",");

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

    private UserLottoDTO userLottoController(Lotto userSixNumber) {
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
