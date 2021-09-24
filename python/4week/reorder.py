import re

def reorder(list, n):
    j = 0  # Count of non-zero elements
    for i in range(n):
        if list[i] != 0:
            # here count is incremented
            list[j] = list[i]
            j += 1
    for i in range(j, n):
        list[i] = 0


# code
print('배열 입력: ', end=' ')
# 숫자인 값만 추출하여 배열 형태로 저장
arr = re.findall(r'\d', input())
n = len(arr)
# 문자형 배열을 숫자형 배열로 변경
list = list(map(int, arr))
# 재정렬 함수 호출
reorder(list, n)

print('정렬 후 배열: ', list)
