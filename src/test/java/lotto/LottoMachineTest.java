package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoMachineTest {
    @Test
    void 입력값이_유효하지_않을_때_예외_처리_후_재입력() {
        LottoMachine lottoMachine = new LottoMachine();

        String dummyInput = "a\na\n1000";
        TestUtils.setInputStream(dummyInput);

        lottoMachine.runMachine();
    }

//    @Test
//    void 로또_개수만큼_발행_확인() {
//        // Given: 로또 개수를 미리 설정
//        int expectedTicketNum = 5;
//        when(dataMock.getTicketNum()).thenReturn(expectedTicketNum);
//
//        // When: 로또 티켓 발행 메서드 실행
//        lottoMachine.issueLottoTickets();
//
//        // Then: 로또 티켓이 설정된 개수만큼 발행되었는지 확인
//        verify(dataMock, times(expectedTicketNum)).addLottoTicket(anyList());
//    }
}