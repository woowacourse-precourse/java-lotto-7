# java-lotto-precourse

1. 사용자의 입력을 받는 InputHandler 클래스
    - 아래의 항목을 입력 받음
      - 구입 금액
      - 로또 당첨 번호
      - 보너스 번호
    - 검증기를 이용해 입력을 검증

2. 로또 진행을 위한 사항을 출력하는 OutputHandler 클래스
   - 진행을 위한 안내문 출력
   - 생성된 티켓 목록 출력
   - 최종 결과를 요약해서 출력

3. 입출력을 관리하는 IOHandler 클래스
   - 특정 입력을 받을 때 안내문을 출력하는 것과 입력을 받는 것은 별개의 과정이 아님
   - 따라서 IOHandler 클래스로 InputHandler와 OutputHandler를 감싸 한 번 더 추상화
   - 이를 통해 LottoMachine이 하나의 객체를 통해 I/O를 진행할 수 있게 함

4. 입력 검증을 하는 Validator 클래스
    - 구입 금액이 1000의 배수인지 검증
    - 로또 당첨 번호가 검증
      - 중복된 숫자가 없어야 함
      - 6개의 숫자가 띄어쓰기 없이 쉼표로 구분되어야 함
    - 보너스 번호 검증
      - 1 ~ 45 중 하나여야 함
      - 로또 당첨 번호에 없는 숫자여야 함 
    - 올바른 입력이 아니면 IllegalArgumentException을 발생
    - 올바른 입력을 입력할 때까지 반복해서 입력을 받음

5. 당첨 로또를 나타내는 Lotto 클래스
   - 당첨 번호를 멤버 변수로 갖고 있음
   - 사용자의 번호와 당첨 번호를 비교하는 등 당첨 번호와 관련된 로직 수행

6. 사용자가 구매한 티켓을 나타내는 LottoTicket 클래스

7. 사용자가 구매한 모든 티켓을 나타내는 LottoTickets 클래스
   - LottoTicket의 리스트를 추상화한 일급 컬렉션
   - 모든 티켓을 순회하며 수행해야 하는 로직을 담음

8. 로또 순위를 나타내는 LottoPlace
   - 로또 순위가 성의된 enum
   - 각 상수는 당첨 금액과 당첨 결과 안내 문구를 갖고 있음
   - 당첨 순위에 해당하는 상수만 제공할 수도 있음

9. LottoPlaceDecidable
   - 로또 순위 결정기가 가져야한 스펙을 나타낸 인터페이스
   - support 메소드
     - 자신이 티켓에게 순위를 제공할 수 있는지를 따지는 메소드
   - decide 메소드
     - 자신이 순위를 제공할 수 있으면 순위에 맞는 LottoPlace enum 상수를 반환

10. LottoPlaceDecider
    - 로또 순위 결정기가 상수로 모여있는 enum
    - 결정기마다 개별 클래스를 만들 수 있지만 순위가 추가되는 등 요구사항이 바뀌면 매번 클래스를 만들어야 함
    - 따라서 결정기를 enum의 상수로 한 곳에 모아 관리해보고자 함
    - 로또 당첨 번호와 티켓을 비교하여 일치하는 숫자와 보너스 번호 포함 유무를 주면 알맞은 검증기를 찾아 티켓의 상황에 맞는 순위를 반환
    - 9번과 10번을 통해 한 티켓의 순위를 결정할 때 사용되는 반복적인 if 문을 제거

11. 로또 진행을 담당하는 LottoMachine 클래스

12. 프로그램의 진입점인 Application 클래스
