package basic;

/**
 * 这里介绍所有的关于位运算的方法
 * 其中numberOf1_1 - numberOf1_3是计算一个整数的二进制中有多少个1
 * 
 * @author S0S
 *
 */
public class NumberOf1 {

	/*
	 * 问题：计算一个整数的二进制中有多少个1
	 * 分析：利用位运算，这个方法完美的解决了统计一个数二进制中1的个数，但是有一个问题，当我们输入的数为负数时，这个方法就不是那么的强大的。
	 * 比如0x80000000,运算的时候会发生什么情况？
	 * 把负数0x80000000右移以为的时候，并不是把最高位的1移到第二位变成0x40000000
	 * ,而是0xC0000000。这是因为一位前是一个负数
	 * ，仍然要保证移位后也是一个负数，因此移位后的最高位会设为1。如果一直做右移运算，最终这个数字就会变成0xFFFFFFFF(-1)而陷入死循环。
	 */
	public int numberOf1_1(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 1)
				count++;
			n >>= 1;
		}
		return count;
	}

	/*
	 * 问题：计算一个整数的二进制中有多少个1
	 * 分析：为了避免上述方法出现死循环，我们可以不右移输入的数字n，首先把n和1做与运算，判断n的最低位是不是为1.接着把1左移移位得到2，再和n做与运算，
	 * 就能判断n的次低位是不是1……这样反复左移，每次都能判断n的其中一位是不是1.基于这个思路，改进的程序如下：
	 */
	public int numberOf1_2(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) == 1)
				count++;
			flag <<= 1;
		}
		return count;
	}

	/*
	 * 问题：计算一个整数的二进制中有多少个1
	 * 分析：针对此题，numberOf1_2解法中循环的次数等于二进制数的位数，32为的整数需要循环32次。 还有一种解法，再分析算法之前，
	 * 我们先来分析把一个数减去1的情况。如果一个整数不等于0，那么该整数的二进制中至少有一位是1. 先假设这个整数的最右边一位是1
	 * ，那么减去1时，最后一位变成0而其它所有的位有保持不变。也就是最后一位相当于做了取反，由1变成了0。接下来假设最后一位不是1而是0的情况
	 * 。如果该整数的二进制表示中最右边1位于第m位
	 * ，那么减去1时，第m位由1变成0，而第m位之后的所有0变成1，整数中第m位之前的所有位都保持不变。举个例子
	 * ：一个二进制1100，它的第二位是从最右边数起的一个1
	 * .减去1后，第二位变成0，它后面的两位0变成1，而前面的1保持不变，因此得到的结论是1011
	 * 。在前面两种情况中，我们发现把一个整数减去1，都是把最右边的1变成0
	 * .如果它的右边还有0的话，所有的0都变成1，二它的左边所有的位都保持不变。接下来我们把一个整数减去1的结果做位与运算
	 * ，相当于把它最右边的1变成0。还是以前面的1100为例
	 * ，它减去1的结果是1011。我们再把1100和1011做位与运算，的到的结果为1000.我们把1100左右边的1变成了0
	 * ，结果刚好就是1000。所以把上述分析总结起来就是
	 * ：把一个整数减去1，再和原整数做位与运算，会把整数右边一个1变成0.那么一个整数的二进制表示中又多少1，就可以进行多少次这样的操作。
	 */
	public int numberOf1_3(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	/*
	 * 问题：判断一个整数是不是2的整数次方。
	 * 分析：针对上边的分析，我们知道如果一个整数是2的整数次方，它的二进制中肯定只有一个1。我们把这个整数减去1之后再和它自己做位与运算
	 * ，这个整数如果是如果变成0，则就是2的整数次方，否则就不是
	 */
	public boolean isPow2(int n) {
		return (n & (n - 1)) == 0 ? true : false;
	}

	/*
	 * 问题：两个整数m，n，计算需要该变m的二进制表示中的多少位才能得到n。比如9的二进制为1001，12的二进制为1100，需要改变其中的2位才能得到1100
	 * 分析：我们可以分两步对此题求解，首先对m和n异或，然后再统计异或之后的值中有多少个1。
	 */
	public int mToN(int m, int n) {
		int temp = m ^ n;
		// return numberOf1_3(temp);
		int count = 0;
		while (temp != 0) {
			count++;
			temp = (temp - 1) & temp;
		}
		return count;
	}
}
