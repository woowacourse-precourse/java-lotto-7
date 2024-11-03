package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import camp.nextstep.edu.missionutils.test.NsTest;

class LottoMachineTest {
//    @Test
//    void 입력값이_유효하지_않을_때_예외_처리_후_재입력_금액() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("a", "b", "1000", "1,2,3,4,5,6");
//
//        lottoMachine.runMachine();
//    }

//    @Test
//    void 금액_저장_확인() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("10000", "1,2,3,4,5,6");
//
//        lottoMachine.runMachine();
//        assertThat(lottoMachine.getData().getAmount()).isEqualTo(10000);
//        assertThat(lottoMachine.getData().getTicketNumber()).isEqualTo(10);
//    }

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

//    @Test
//    void 입력값이_유효하지_않을_때_예외_처리_후_재입력_번호() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("1000", "1", "1,2,3,4,5,6");
//
//        lottoMachine.runMachine();
//    }

//    @Test
//    void 번호_저장_확인() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("1000", "1,2,3,4,5,6");
//
//        lottoMachine.runMachine();
//        assertThat(lottoMachine.getData().getUserPick().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
//    }

//    @Test
//    void 입력값이_유효하지_않을_때_예외_처리_후_재입력_보너스() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("1000", "1,2,3,4,5,6", "45", "7");
//
//        lottoMachine.runMachine();
//    }

//    @Test
//    void 보너스_저장_확인() {
//        LottoMachine lottoMachine = new LottoMachine();
//
//        TestUtils.setInputStream("1000", "1,2,3,4,5,6", "45");
//
//        lottoMachine.runMachine();
//        assertThat(lottoMachine.getData().getUserPick().getBonus()).isEqualTo(45);
//    }
}