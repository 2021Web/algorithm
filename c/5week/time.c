#include <stdio.h>
// bool 타입 함수 사용 위함
#include <stdbool.h>

// 특정한 시각 안에 '3'이 포함되어 있는지의 여부
bool check(int h, int m, int s)
{
    if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
    {
        return true;
    }
    else
    {
        return false;
    }
};

int main()
{
    int h;
    int count = 0;
    // H 입력 받기
    scanf("%d", &h);

    for (int i = 0; i <= h; i++)
    {
        for (int j = 0; j < 60; j++)
        {
            for (int k = 0; k < 60; k++)
            {
                if (check(i, j, k))
                {
                    count += 1;
                }
            }
        }
    }

    printf("%d", count);
    return 0;
}