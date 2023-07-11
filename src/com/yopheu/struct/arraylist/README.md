# ArrayList
## 구현 내용
	- List Interface 를 구현
	- Interface의 내용을 기반으로 구현
## 메인줄기 개념적 내용
	- 배열을 사용하였기 때문에 중간 부분에 추가 삭제가 일어날 경우 커다란 데이터 이동이 생김
### 곁가지 습득 내용
	- clean() 사용시 용적(배열크기)를 초기화 하지 않고 반으로 줄이는 이유.
	- remove() 사용시 손수 null로 처리해주는 이유.
	- add()는 `index > size`, remove()set()get()은 `index >= size` 인 이유

## 추가구현 needs.
- Iterable의 일부 내용을 구현하고 싶음.