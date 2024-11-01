package lotto.back.global.support;

import lotto.back.lotto.controller.LottoController;
import lotto.global.communication.CustomCommunicationCode;
import lotto.global.communication.CustomCommunicationData;
import lotto.global.communication.Telecommunication;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.exception.CustomIllegalArgumentException;

public class FrontController {

    public static void run() {
        while (true) {
            CustomCommunicationData customCommunicationData = Telecommunication.receiveFromFront();
            if (customCommunicationData.code() == CustomCommunicationCode.TERMINATE) {
                break;
            }
            Object requestObject = customCommunicationData.response();

            try {
                Object response = lottoRequestHandling(requestObject);
                Telecommunication.sendSuccessToFront(response);
            } catch (CustomIllegalArgumentException e) {
                Telecommunication.sendErrorToFront(e.getMessage());
            }
        }
    }

    //TODO 로직 구현 시 각 메서드로 redirect되도록 구현
    private static Object lottoRequestHandling(Object requestObject) {
        LottoController lottoController = BeanConfig.getBean(LottoController.class);

        if (requestObject instanceof PurchaseLottoRequestDTO purchaseLottoRequestDTO) {
            return lottoController.purchase(purchaseLottoRequestDTO);
        } else if (requestObject instanceof SetPrizeLottoRequestDTO setPrizeLottoRequestDTO) {
            lottoController.setPrizeLotto(setPrizeLottoRequestDTO);
            return null;
        }

        throw new RuntimeException("잘못된 요청입니다.");
    }
}
