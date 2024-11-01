package lotto.front;

import java.util.UUID;
import java.util.function.Function;
import lotto.front.view.LottoRequestView;
import lotto.front.view.LottoResponseView;
import lotto.global.communication.CustomCommunicationCode;
import lotto.global.communication.CustomCommunicationData;
import lotto.global.communication.Telecommunication;
import lotto.global.dto.request.LottoResultRequestDTO;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.dto.response.LottoResultResponseDTOs;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;
import lotto.global.exception.CustomIllegalArgumentException;

public class FrontApplication {

    public static void run() {
        try {
            runProcedure();
        } finally {
            Telecommunication.sendTerminateSignalToBack();
        }
    }

    private static void runProcedure() {
        Function<Object, Object> purchaseFunction = o -> runPurchase();
        Function<Object, Object> getPrizeFunction = uuidObject -> {
            runGetPrizeNumbers((UUID) uuidObject);
            return null;
        };
        Function<Object, Object> getResultFunction = uuidObject -> {
            runGetResult((UUID) uuidObject);
            return null;
        };

        UUID uuid = (UUID) executeWithRetry(purchaseFunction, null);
        executeWithRetry(getPrizeFunction, uuid);
        executeWithRetry(getResultFunction, uuid);
    }

    private static Object executeWithRetry(Function<Object, Object> function, Object param) {
        while (true) {
            try {
                return function.apply(param);
            } catch (CustomIllegalArgumentException e) {
                LottoResponseView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static UUID runPurchase() {
        PurchaseLottoRequestDTO purchaseLottoRequestDTO = LottoRequestView.requestPurchasePrice();
        
        CustomCommunicationData response = Telecommunication.requestToBack(purchaseLottoRequestDTO);
        if (response.code() == CustomCommunicationCode.ERROR) {
            throw new CustomIllegalArgumentException(response.errorMessage());
        }

        PurchasedLottoResponseDTOs purchasedLottoResponseDTOs = (PurchasedLottoResponseDTOs) response.response();
        LottoResponseView.purchaseResponse(purchasedLottoResponseDTOs);

        return purchasedLottoResponseDTOs.uuid();
    }

    private static void runGetPrizeNumbers(UUID uuid) {
        SetPrizeLottoRequestDTO setPrizeLottoRequestDTO = LottoRequestView.requestPrizeNumbers(uuid);
        
        CustomCommunicationData response = Telecommunication.requestToBack(setPrizeLottoRequestDTO);
        if (response.code() == CustomCommunicationCode.ERROR) {
            throw new CustomIllegalArgumentException(response.errorMessage());
        }
    }

    private static void runGetResult(UUID uuid) {
        LottoResultRequestDTO lottoResultRequestDTO = LottoRequestView.requestBonusNumber(uuid);
        
        CustomCommunicationData response = Telecommunication.requestToBack(lottoResultRequestDTO);
        if (response.code() == CustomCommunicationCode.ERROR) {
            throw new CustomIllegalArgumentException(response.errorMessage());
        }
        
        LottoResultResponseDTOs lottoResults = (LottoResultResponseDTOs) response.response();
        LottoResponseView.printPrizeResult(lottoResults);
    }
}
