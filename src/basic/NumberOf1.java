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
		System.out.println(nbo.numberOf1_2(input));
		sc.close();
	}

	/**
	 * ����λ���㣬������������Ľ����ͳ��һ������������1�ĸ�����������һ�����⣬�������������Ϊ����ʱ����������Ͳ�����ô��ǿ��ġ�
	 * ����0x80000000,�����ʱ��ᷢ��ʲô�����
	 * �Ѹ���0x80000000������Ϊ��ʱ�򣬲����ǰ����λ��1�Ƶ��ڶ�λ���0x40000000
	 * ,����0xC0000000��������Ϊһλǰ��һ������
	 * ����ȻҪ��֤��λ��Ҳ��һ�������������λ������λ����Ϊ1�����һֱ���������㣬����������־ͻ���0xFFFFFFFF(-1)��������ѭ����
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

	/**
	 * Ϊ�˱�����������������ѭ�������ǿ��Բ��������������n�����Ȱ�n��1�������㣬�ж�n�����λ�ǲ���Ϊ1.���Ű�1������λ�õ�2���ٺ�n�������㣬
	 * �����ж�n�Ĵε�λ�ǲ���1���������������ƣ�ÿ�ζ����ж�n������һλ�ǲ���1.�������˼·���Ľ��ĳ������£�
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

	public int numberOf1_3(int n) {
		return 0;
	}
}
