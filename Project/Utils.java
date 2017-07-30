package com.cWww.project4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

	@SuppressWarnings("unchecked")
	public static ArrayList<Student> read(){
		ArrayList<Student> list = new ArrayList<>();
		File file = new File(Config.PATH);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			Object obj = ois.readObject();
			list = (ArrayList<Student>)obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(ois!=null){ois.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void write(ArrayList<Student> list){
		File file = new File(Config.PATH);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(oos != null){oos.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Scanner getScanner(){
		return new Scanner(System.in);
	}
	
}
