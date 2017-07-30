package com.cWww.project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * ����ѧ������ϵͳ
 * @author Administrator
 *
 */
public class SimpleManager {

	private ArrayList<Student> list = new ArrayList<>();
	private Student s;
	
	
	public SimpleManager() {
		list = Utils.read();
	}
	

	public void start(){
		System.out.println("1:���ѧ��,2:�޸�ѧ��,3:��ѯ����ѧ��,4:ɾ��ѧ��,5:�˳�");
		menu();
	}
	
	private void menu(){
		Scanner sc = Utils.getScanner();
		System.out.println("������ָ��:");
		int num = sc.nextInt();
		switch(num){
		case 1:
			add();
			break;
		case 2:
			change();
			break;
		case 3:
			showAll();
			break;
		case 4:
			delete();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			menu();
			break;
		}
	}
	/**
	 * ɾ��
	 */
	private void delete() {
		System.out.println("������Ҫɾ����ѧ��:");
		Scanner sc = Utils.getScanner();
		int num = sc.nextInt();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			s = it.next();
			if(s.getSno() == num){
				it.remove();
				System.out.println("ɾ���ɹ�!");
				break;
			}
		}
		Utils.write(list);
		menu();
	}

	/**
	 * �鿴����
	 */
	private void showAll() {
		
		for(Student stu : list){
			System.out.println(stu);
		}
		menu();
	}

	/**
	 * �޸�
	 */
	private void change() {
		System.out.println("��������Ҫ�޸ĵ�ѧ��");
		Scanner sc = Utils.getScanner();
		int num = sc.nextInt();
		System.out.println("�������޸ĺ����Ϣ");
		String info = sc.next();
		String[] infos = info.trim().split("/");
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			s = it.next();
			if(s.getSno() == num){
				s.setSno(Integer.valueOf(infos[0]));
				s.setName(infos[1]);
				s.setSex(infos[2]);
				s.setAge(Integer.valueOf(infos[3]));
				System.out.println("�޸ĳɹ�!");
				Utils.write(list);
				menu();
				break;
			}
		}
		change();
	}

	/**
	 * ����
	 */
	private void add() {
		System.out.println("������ѧ����Ϣ(ѧ��/����/�Ա�/����):");
		Scanner sc = Utils.getScanner();
		String info = sc.next();
		String[] infos = info.trim().split("/");
		s = new Student(Integer.valueOf(infos[0]),infos[1],infos[2],Integer.valueOf(infos[3]));
		list.add(s);
		System.out.println("��ӳɹ�����");
		Utils.write(list);
		menu();
	}
	
	public static void main(String[] args) {
		
		new SimpleManager().start();
	}
	
}
