read = input().split()
n = int(read[0])
k = int(read[1])
cnt = 0

coinList = []
for i in range(n):
    coinList.append(int(input()))

for coin in reversed(coinList):
    cnt += k // coin
    k %= coin

print(cnt)