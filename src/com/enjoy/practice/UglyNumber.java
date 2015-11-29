package com.enjoy.practice;

/**
 * 丑数
 * 
 * 我们把只包含因子2、3和5的数成为丑数。
 * 求：按从小到大顺序的第1500个丑数。例如6和8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。
 * 
 * @author S0S
 * 
 */
public class UglyNumber {

	/**
	 * 判断一个数是不是丑数 算法思路：
	 * 所谓一个数m是另一个数n的因子，是指n能被m整除，也就是说n%m==0。根据丑数的定义，丑数只能被2，3和5整除。
	 * 也就是说如果一个数只能被2整除，我们把它连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就连续除以5。
	 * 如果我们最后得到的是1，那么这个数就是丑数，否则不是。
	 * 
	 * @param number
	 * @return
	 */
	public boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return number == 1 ? true : false;
	}

	/**
	 * 获取第index个丑数
	 * 
	 * @param index
	 * @return
	 */
	public int getUglyNumber_01(int index) {
		if (index <= 0)
			return 0;
		int number = 0;
		int uglyFound = 0;
		while (uglyFound < index) {
			number++;
			if (isUgly(number)) {
				uglyFound++;
			}
		}
		return number;
	}

	/**
	 * 1.上述求丑数的方法，我们发现它的效率特别的低，我在本地测得，求第1500个丑数，用时8秒多，可见它的效率特别的差。
	 * 	前面的算法之所以效率特别低，很大程度上是因为不管一个数是不是丑数我们对它都做了计算。接下来我们尝试找一种只要
	 * 	计算丑数的方法，而不把时间花费在费丑数上边。根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果。因此我们
	 * 	可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是钱的丑数乘以2、3或者5得到。
	 * 2.这种思路的关键在于怎么确保数组里边保存的丑数是排好序的。假设数组中已经有若干个丑数排好序后存放在数组中，并且
	 *  把已有的最大丑数记做M，我们接下来分析如何生成下一个丑数。该丑数肯定是前面某一个丑数乘以2、3或者5的结果，所以
	 *  我们首先考虑把已拥有的每个丑数乘以2。在乘以2的时候，能得到若干个小于或等于M的结果。由于是按照顺序生成的，小于
	 *  或者等于M肯定已经在数组中了，我们不需要再次考虑；还会得到若干个大于M的结果，但我们只需要第一个大于M的结果，因
	 *  为我们希望丑数是按从小到大的顺序生成的，其他更大的结果以后再说。我们把得到的第一个生乘以2后大于M的结果记为M2。
	 *  同样，我们把已有的丑数乘以3和5，能得到第一个大于M的结果M3和M5。那么下一个丑数应该是M2、M3和M5这3个数的最小者。
	 * 3.前面分析的时候，提到把已有的每个丑数分别度乘以2、3和5.事实上这不是必须的，因为已有的丑数是按顺序存放在数组中
	 *  的。对乘以2而言，肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2得到结果都会小于已有最大的丑数，在它之后的每
	 *  一个丑数乘以2的到的结果都会太大。我们只需几下这个丑数的位置，同时每次生成新的丑数的时候，去更新这个T2。对乘以3
	 *  和5而言，也存在着同样的T3和T5。
	 * 
	 * @param index
	 * @return
	 */
	public int getUglyNumber_02(int index) {
		if (index <= 0)
			return 0;
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyNumberIndex = 1;
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		while (nextUglyNumberIndex < index) {
			int min = Math.min(Math.min(uglyNumbers[multiply2] * 2,
					uglyNumbers[multiply3] * 3), uglyNumbers[multiply5] * 5);
			if (min == uglyNumbers[multiply2] * 2) {
				++multiply2;
			}
			if (min == uglyNumbers[multiply3] * 3) {
				++multiply3;
			}
			if (min == uglyNumbers[multiply5] * 5) {
				++multiply5;
			}
			uglyNumbers[nextUglyNumberIndex++] = min;
		}
		int ugly = uglyNumbers[nextUglyNumberIndex - 1];
		return ugly;
	}

}
