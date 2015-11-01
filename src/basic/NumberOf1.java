package basic;

import java.util.Scanner;

/**
 * ��һ����ת����2���ƣ�2��������ж��ٸ�1
 * 
 * @author S0S
 *
 */
public class NumberOf1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		NumberOf1 nbo = new NumberOf1();
		System.out.println(nbo.numberOf1_1(input));
		sc.close();
	}

	/**
	 * ����λ���㣬������������Ľ����ͳ��һ������������1�ĸ�����������һ�����⣬�������������Ϊ����ʱ����������Ͳ�����ô��ǿ��ġ�
	 * ����0x80000000,�����ʱ��ᷢ��ʲô�����
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
}
