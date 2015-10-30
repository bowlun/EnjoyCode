package basic;

import java.util.Scanner;

/**
 * 测试斐波那契数列
 * 
 * 斐波那契数列数列的应用 问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 分析：
 * 
 * 考虑1个台阶，只有1跳法，则 f(1) = 1
 * 
 * 考虑2个台阶，可以1级级条，可以一次跳2级，有两种跳法,则f(2) = 2
 * 
 * 考虑3个台阶，它可以由1级跳来得到，也可以由2级跳来得到，所以它的跳法为 f(3-1) + f(3-2) = f(1) + f(2)
 * 
 * 考虑n个台阶，它的跳法为 f(n-1) + f(n-2)
 * 
 * 实则上为斐波那契数列。可以用递归，也可以用循环方法求解。
 * 
 * @author S0S
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Fibonacci f = new Fibonacci();
		System.out.print(f.fibonacci2(n) + " ");
	}

	/**
	 * 循环实现斐波那契数列
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci1(int n) {
		if (n <= 0)
			return -1;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int pre = 0, next = 1;
		int curr = 0;
		for (int i = 2; i <= n; i++) {
			curr = pre + next;
			pre = next;
			next = curr;
		}
		return curr;
	}

	/**
	 * 递归实现
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci2(int n) {
		int[] result = { 0, 1, 2 };
		return n < 3 ? (n < 0 ? 0 : result[n]) : fibonacci2(n - 1)
				+ fibonacci2(n - 2);
	}

	/**
	 * 变态青蛙跳台阶 一只青蛙一次可以跳一级台阶，也可以跳两级台阶……，更可以跳n级台阶，问：n级台阶共有多少中跳法？
	 *  分析：f(1) = 1
	 *		f(2)= f(2-1) + f(2-2) 
	 * 		f(3) = f(3-1) + f(3-2) + f(3-3)
	 * 		 …… 
	 *		f(n) = f(n-1) + f(n-2) + f(n-3) + …… + f(n - n)
	 *	说明：1.这里的f(n)代表的是个台阶有一次1，2，3，……n阶的跳法数。
	 *		2.n=1时，只有一种跳法，f(1) = 1
	 *		3.n=2时，会有两种不同的跳法，一次1阶或者2阶，这回归到了1，f(2) = f(2-1) + f(2-2)
	 *		4.n=3时，会有三种跳的方式，1阶、2阶、3阶，那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2);第一次3阶，那么剩下的f(3-3)，因此结论是f(3) = f(3-1) + f(3-2) + f(3-3)
	 *		5.n=n时，会有n种跳台阶的方式，1阶、2阶、……、n阶，得出结论：f(n) = f(n-1) + f(n-2) + f(n-3) + …… + f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + …… + (n-1)
	 *		6.由以上已经是一种结论了，但是为了简单，我们可以继续简化：f(n-1) = f(0) + f(1) + f(2) + f(3) + …… + f(n-(n-1)) = f(0) + f(1) + f(2) + f(3) + …… + f(n-2)
	 *															f(n) = f(0) + f(1) + f(2) + f(3) + …… + f(n-1) = f(n-1) + f(n-1)
	 *			可以得出：f(n) = 2*f(n-1);
	 *		7.得出最终结论，在n阶台阶，一次有1、2、……、n阶的跳的方式，总的跳法为：
	 *					| -1,(n <= 0)
	 *			f(n) = 	| 1,(n = 1)
	 *					| 2*f(n-1),(n >= 2)
 	 */
	public int jumpFloor1(int n) {
		if(n <= 0)
			return -1;
		else if(n == 1)
			return 1;
		return 2 * jumpFloor1(n - 1);
	}
	
	/**
	 * 针对上题，有一个变态的解法
	 * 当n=1时，有1种解法，1 << --1;
	 * 当n=2时，有2种解法，1 << --2;
	 * 当n=3时，有4种解法，1 << --3;
	 * 当n=4时，有8种解法，1 << --4;
	 * 当n=5时，有16种解法，1 << --5;
	 * ……
	 * 当n=n时，有2种解法，1 << --n;
	 */
	public int jumpFloor2(int n) {
		return 1 << --n;
//		return Math.pow(2, n - 1);
	}
}
