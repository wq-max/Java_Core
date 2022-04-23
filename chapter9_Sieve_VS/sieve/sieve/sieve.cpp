// sieve.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <bitset>
#include <ctime>

using namespace std;

int main()
{
    const int N = 8000000;
    clock_t cstart = clock();

    bitset<N + 1> b;
    int count = 0;
    int i;
    for (i = 2; i <= N; i++)
        b.set(i);
    i = 2;
    while (i * i <= N)
    {
        if (b.test(i))
        {
            count++;
            int k = 2 * i;
            while (k <= N)
            {
                b.reset(k);
                k += i;
            }
        }
        i++;
    }
    while (i <= N)
    {
        if (b.test(i))
        {
            count++;
        }
        i++;
    }
    clock_t cend = clock();
    double millis = 1000.0 * (cend - cstart) / CLOCKS_PER_SEC;

    cout << count << " primes\n" << millis << " milliseconds\n";

    return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
