package basic;

/**
 * ��һ����֪����ֳ������� ����һ����֪�����飬��������������������е�Ԫ�ذ���ĳ�ֹ��ɷֳ������֣�
 * �������ǽ�һ�������е�����������ǰ��ż�����ں�,����һ��ĵ�һ��Ӧ�ǽ���������ͷɨ��λ
 * ������һ��ż�����ó�������֣�����λ��������ֺ��������������ǰŲ��һλ
 * ��Ų��֮���������ĩβ��һ����λ����ʱ��Ѹ����ַ��������λ����������û����һ��ż������Ҫ�ƶ�0
 * ��n�������֣���ʱ�ܵ�ʱ�临�ӶȾ�ΪO(n^2)���ⲻ��һ����ѵĽⷨ��������д��һ�ֽⷨ�������Ҳο���
 * 
 * @author S0S
 *
 */
public class Reorder {

	public interface IsTrue {
		public boolean isTrue(int key);
	}

	public static void main(String[] args) {
		int[] source = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Reorder even = new Reorder();
		int[] oddEven = even.reorderOddEven_0(source);
		for (int i : oddEven)
			System.out.print(i + " ");
		oddEven = even.reorderThreeAliquot(source);
		System.out.println();
		for (int i : oddEven)
			System.out.print(i + " ");
	}

	/*
	 * ���⣺�������е�Ԫ����������ǰ��ż�����ں�
	 * ��������������ָ����һ��ָ�루begin��ָ���������λ��һ��ָ�루end��ָ�������ĩβ����λָ�루begin
	 * ����ǰ����ɨ�裬ֱ����ָ��ָ��ż����ĩβָ�루end���Ӻ���ǰɨ�裬ֱ����ָ��ָ��������Ȼ������ָ��λ��Ԫ�ؽ��н�����
	 */
	public int[] reorderOddEven_0(int[] source) {
		if (source == null | source.length == 0)
			return null;
		int begin = 0;
		int end = source.length - 1;
		while (begin < end) {
			while (begin < end && (source[begin] & 0x01) == 1)
				begin++;
			while (begin < end && (source[end] & 0x01) == 0)
				end--;
			int temp = source[begin];
			source[begin] = source[end];
			source[end] = temp;
		}
		return source;
	}

	/*
	 * ���⣺�������е�Ԫ����������ǰ��ż�����ں�
	 * ���������ڴ��⣬��������Ѿ�����һ���ܺõĽ�����������ǣ�����������ⲻ�ǽ�������ż�����룬���ǽ�����������������ô��
	 * ������ܶ���Ӧ�û�˵������ֻ��Ҫ�޸ĵ�2
	 * ��3��while��ߵ��ж������Ϳ����ˡ����������������Ҫ���ܱ�3�����Ͳ��ܱ�3���������ֿ����������ǿ����ֻ�˵����ֻ��Ҫ����2
	 * ��3��while��ߵ��ж������޸�һ�¾Ϳ�����
	 * �����ǣ����ǻᷢ�����δ��룬���˵�2��3��while���ж�������֮ͬ�⣬�����Ĵ��붼���䣬��ʱ���Ǿ�Ҫ���ǵĳ���Ŀ���չ�ԡ�
	 * �ⷨ���������Ǿͻ��뵽java�Ļص�������ֻ��Ҫ�����ж�����ͨ���ص���Ȼ�����ϲ㺯����ʵ�ֶ�����жϾͿ����ˡ�����ʵ�����¡�
	 */
	public int[] reorderOddEven_1(int[] source) {
		return reorder(source, new IsTrue() {
			@Override
			public boolean isTrue(int key) {
				return (key & 1) == 0 ? false : true;
			}
		});
	}

	/*
	 * ���⣺�������е�Ԫ���ܱ�3�����ķ���ǰ�����ܱ�3�����������ں���
	 * ����������������һ��ķ�����ֻ��Ҫʵ�ֶ�IsTrue�ӿ���isTrue������ʵ�־Ϳ����ˡ�
	 */
	public int[] reorderThreeAliquot(int[] source) {
		return reorder(source, new IsTrue() {
			@Override
			public boolean isTrue(int key) {
				return (key % 3) != 0 ? false : true;
			}
		});
	}

	public int[] reorder(int[] source, IsTrue is) {
		if (source == null | source.length == 0)
			return null;
		int begin = 0;
		int end = source.length - 1;
		while (begin < end) {
			while (begin < end && is.isTrue(source[begin]))
				begin++;
			while (begin < end && !is.isTrue(source[end]))
				end--;
			int temp = source[begin];
			source[begin] = source[end];
			source[end] = temp;
		}
		return source;
	}
}
