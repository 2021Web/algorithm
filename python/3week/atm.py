# N, K 입력 받기
n = int(input())
# 결과
result = 0
# 걸리는 시간 배열 입력 받기
timeList = list(map(int, input().split()))

# 오름차순으로 정렬
timeList.sort()

# 걸리는 시간의 합 계산 (n만큼만)
for i in range(n):
    result += timeList[i] * (n - i)

print(result)
