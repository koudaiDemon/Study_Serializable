package com.cWww.project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 简易学生管理系统
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
		System.out.println("1:添加学生,2:修改学生,3:查询所有学生,4:删除学生,5:退出");
		menu();
	}
	
	private void menu(){
		Scanner sc = Utils.getScanner();
		System.out.println("请输入指令:");
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
	 * 删除
	 */
	private void delete() {
		System.out.println("请输入要删除的学号:");
		Scanner sc = Utils.getScanner();
		int num = sc.nextInt();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			s = it.next();
			if(s.getSno() == num){
				it.remove();
				System.out.println("删除成功!");
				break;
			}
		}
		Utils.write(list);
		menu();
	}

	/**
	 * 查看所有
	 */
	private void showAll() {
		
		for(Student stu : list){
			System.out.println(stu);
		}
		menu();
	}

	/**
	 * 修改
	 */
	private void change() {
		System.out.println("请输入需要修改的学号");
		Scanner sc = Utils.getScanner();
		int num = sc.nextInt();
		System.out.println("请输入修改后的信息");
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
				System.out.println("修改成功!");
				Utils.write(list);
				menu();
				break;
			}
		}
		change();
	}

	/**
	 * 增加
	 */
	private void add() {
		System.out.println("请输入学生信息(学号/姓名/性别/年龄):");
		Scanner sc = Utils.getScanner();
		String info = sc.next();
		String[] infos = info.trim().split("/");
		s = new Student(Integer.valueOf(infos[0]),infos[1],infos[2],Integer.valueOf(infos[3]));
		list.add(s);
		System.out.println("添加成功！！");
		Utils.write(list);
		menu();
	}
	
	public static void main(String[] args) {
		
		new SimpleManager().start();
	}
	
}
