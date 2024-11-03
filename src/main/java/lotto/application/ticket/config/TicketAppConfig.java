package lotto.application.ticket.config;


import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;

public class TicketAppConfig {
    private final ViewConfig viewConfig;
    private final ControllerConfig controllerConfig;
    private final ServiceConfig serviceConfig;
    private final RepositoryConfig repositoryConfig;

    public TicketAppConfig() {
        this.viewConfig = new ViewConfig(
                getTicketInputView(),
                getTicketOutputView()
        );
        this.repositoryConfig = new RepositoryConfig(
                getTicketWriteRepository(),
                getTicketReadRepository(),
                getPaymentWriteRepository()
        );
        this.serviceConfig = new ServiceConfig(
                repositoryConfig.getPaymentWriteRepository(),
                repositoryConfig.getTicketReadRepository(),
                repositoryConfig.getTicketWriteRepository()
        );

        this.controllerConfig = new ControllerConfig(
                serviceConfig.getPaymentWriteService(),
                serviceConfig.getTicketWriteService(),
                serviceConfig.getTicketReadService()
        );
    }

    public ControllerConfig getControllerConfig() {
        return controllerConfig;
    }

    private TicketInputView getTicketInputView() {
        return new TicketInputView();
    }

    private TicketOutputView getTicketOutputView() {
        return new TicketOutputView();
    }

    private TicketWriteRepository getTicketWriteRepository() {
        return new TicketWriteRepository();
    }

    private TicketReadRepository getTicketReadRepository() {
        return new TicketReadRepository();
    }

    private PaymentWriteRepository getPaymentWriteRepository() {
        return new PaymentWriteRepository();
    }

}
