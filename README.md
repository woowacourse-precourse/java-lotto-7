# java-lotto-precourse

## 객체 설계
- 로또 `Lotto`
    - 상태
        - 로또 번호 리스트 `List<LottoNumber>`
            - 크기를 6으로 제한
            - LottoNumber 는 중복 불가능
        - ❓가격
            - 1장당 1000원 고정
- 로또 번호 `LottoNumber`
    - VO
        - 값으로 동등성 비교
    - 1~45 사이의 숫자
- 로또 공장 `LottoFactory`
    - 다양한 로또 발행기로 로또를 발행한다.
    - 발행할 로또 개수
- 로또 일급 컬렉션 `Lottos`
    - 로또 리스트 `List<Lotto>`
    - ❓총 금액
- 로또 발매기 `LottoGenerator`
- 랜덤 로또 발매기 `RandomLottoGenerator`
    - 1~45 사이의 중복되지 않은 정수 6개를 반환한다.
- 로또 당첨 판정 서비스
    - 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
    - 당첨 내역 및 수익률을 출력한다.