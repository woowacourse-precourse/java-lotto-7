package lotto.global.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TelecommunicationTest {

    @Test
    void 프론트에_성공_보내기() {
        // given
        Integer responseObject = 333;

        // when
        Telecommunication.sendSuccessToFront(responseObject);
        CustomCommunicationData customCommunicationData = Telecommunication.receiveFromBack();

        // then
        Assertions.assertThat(customCommunicationData.code()).isEqualTo(CustomCommunicationCode.SUCCESS);
        Assertions.assertThat(customCommunicationData.response()).isEqualTo(responseObject);
    }

    @Test
    void 프론트에_에러_보내기() {
        // given
        String errorMessage = "this is error message";

        // when
        Telecommunication.sendErrorToFront(errorMessage);
        CustomCommunicationData customCommunicationData = Telecommunication.receiveFromBack();

        // then
        Assertions.assertThat(customCommunicationData.code()).isEqualTo(CustomCommunicationCode.ERROR);
        Assertions.assertThat(customCommunicationData.errorMessage()).isEqualTo(errorMessage);
    }

    @Test
    void 백에게_요청_보내고_응답_받기() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(1)) {
            // given
            Integer requestObject = 333;
            Integer responseObject = 444;


            executorService.submit(() -> {
                // when
                CustomCommunicationData customCommunicationData = Telecommunication.requestToBack(requestObject);

                // then
                Assertions.assertThat(customCommunicationData.code()).isEqualTo(CustomCommunicationCode.SUCCESS);
                Assertions.assertThat(customCommunicationData.response()).isEqualTo(responseObject);
            });

            CustomCommunicationData receivedData = Telecommunication.receiveFromFront();

            // then
            Assertions.assertThat(receivedData.code()).isEqualTo(CustomCommunicationCode.SUCCESS);
            Assertions.assertThat(receivedData.response()).isEqualTo(requestObject);

            // when
            Telecommunication.sendSuccessToFront(responseObject);
        }
    }

    @Test
    void 백에_종료_신호_보내기() {
        // when
        Telecommunication.sendTerminateSignalToBack();
        CustomCommunicationData customCommunicationData = Telecommunication.receiveFromFront();

        // then
        Assertions.assertThat(customCommunicationData.code()).isEqualTo(CustomCommunicationCode.TERMINATE);
    }
}