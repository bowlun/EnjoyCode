package com.enjoy.test.list;

import java.util.Random;

import org.junit.Test;

import com.enjoy.list.SqList;

/**
 * 线性表测试
 * 
 * @author S0S
 * 
 */
public class SqListTest {

	/**
	 * 创建一个长度为len的线性表
	 * 
	 * @param len 线性表的长度
	 * @return 返回线性表
	 */
	private SqList creatSqList(int len) {
		Random r = new Random();
		SqList sqList = new SqList();
		for (int i = 1; i <= len; i++) {
			Integer obj = r.nextInt(20);
			sqList.add(obj);
		}
		System.out.println("原始表：");
		printSqList(sqList);
		return sqList;
	}

	/**
	 * 打印线性表
	 * 
	 * @param sqList 线性表
	 */
	private void printSqList(SqList sqList) {
		for (int i = 0; i < sqList.size(); i++) {
			System.out.print(sqList.get(i) + " ");
		}
		System.out.println();
	}

	@Test
	public void testRemove() {
		SqList sqList = creatSqList(10);
		System.out.println(sqList.remove(5));
		System.out.println("删除后：");
		printSqList(sqList);
	}

	@Test
	public void testIndexOf() {
		SqList sqList = creatSqList(10);
		System.out.println("5:" + sqList.indexOf(5));
	}

}
