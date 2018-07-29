package com.google.javase.zs;
//快速排序
public class QuickSore{
	public static void quickSore(int[] data, int left, int right) {
		int base;
		if(right>left) {
			base=sort(data,left,right);
			quickSore(data,left,base-1);//小于基准
			quickSore(data,base+1,right);//大于基准
		}
	}
	public static int sort(int[] data, int left, int right) {
		int zj=data[left];
		int base=left,zjz;
		data[left]=data[right];
		data[right]=zj;
		for(int i=left;i<right;++i) {
			if(data[right]>data[i]) {
				zjz=data[base];
				data[base]=data[i];
				data[i]=zjz;
				base++;
			}
		}
		zjz=data[base];
		data[base]=data[right];
		data[right]=zjz;
		return base;       
		
	}
	public static void main(String[] args) {
		int []data= {3,4,1,2,6,4,5,7,8,0,9,43,98,88,5,7};
		quickSore(data,0,data.length-1);
		for(int i=0;i<data.length;++i) {
			System.out.print(data[i]+"  ");
		}
		System.out.println();
	}
}
