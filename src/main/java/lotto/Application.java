package lotto;

import lotto.commons.beans.BeanFactory;
import lotto.commons.lang.InputOverFlowException;
import lotto.commons.lang.ProgramExitException;
import lotto.commons.logger.Logger;
import lotto.core.controller.Controller;
import lotto.core.controller.PurchaseLottoController;
import lotto.core.controller.StartLottoGameController;
import lotto.core.dto.LottoTicketDto;

public class Application {
    public static void main(String[] args) {
        Application.run(() -> {
            Controller<Class<Void>, LottoTicketDto> purchaseLottoController = BeanFactory.findBean(PurchaseLottoController.class);
            LottoTicketDto lottoTicket = purchaseLottoController.request(Void.class);

            Controller<LottoTicketDto, Class<Void>> startLottoGameController = BeanFactory.findBean(StartLottoGameController.class);
            startLottoGameController.request(lottoTicket);
        });
    }

    private static void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (ProgramExitException e) {
            Logger.info(e.getMessage());
        } catch (InputOverFlowException e) {
            Logger.error(e.getMessage());
        } catch (Throwable e) {
            Logger.error(e);
        }
    }
}
