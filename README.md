# java-lotto-precourse

Static final 값 정하기
- Lotto number의 min(1), max(45)
- unit of purchasing prices(1000)
- 
구매 금액 input 받기
- 1000원 단위로 받기
- Number가 아닌 경우 / Positive가 아닌 경우 / 1000원으로 나누어 떨어지지 않는 경우 -> Exception
- Price가 blank를 포함할 경우? Maximum value of Price?

당첨 번호 input 받기
- 쉼표로 구분된 6개의 숫자 받기
- Number가 아닌 경우 / 숫자가 6개가 아닐 시 / positive가 아닌 경우 / 중복된 경우 / 1과 45 사이가 아닐 시-> Exception
- Bonus Number에 대해서도 같은 Login + 기존 당첨 번호와 not be duplicated

로또 발행
- 구매 금액/Unit of purchasing price = 발행할 로또 개수
- 범위 내의 랜덤한 숫자 6개 발행, 오름차순으로 정렬 후 전체 출력