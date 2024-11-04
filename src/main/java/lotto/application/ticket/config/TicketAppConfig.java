package lotto.application.ticket.config;


import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.controller.TicketController;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;

public class TicketAppConfig {
    private final ControllerConfig controllerConfig;
    private final ServiceConfig serviceConfig;
    private final RepositoryConfig repositoryConfig;

    public TicketAppConfig() {

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

    public TicketController getTicketController() {
        return controllerConfig.getTicketController();
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
