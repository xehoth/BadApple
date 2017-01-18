package com.xznn.badapple;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * java版badapple字符动画
 * 在网上找java版的badapple找了很久，
 * 但找到的不是闪屏就是抖屏。
 * 自写一个java版的badapple
 * 已解决闪屏抖屏问题
 * 作者：氙钬钍
 * 由于up主只是一个初中生，不喜勿喷
 * 修改：MapleDev  2016-07-28
 */

public class BadAppleMain {

	public BadAppleMain() {
		JFrame frame = new JFrame();
		JFrame frame1 = new JFrame();
		frame.setBounds(80, 20, 560, 575);
		frame.setResizable(false);// 不可改变大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭方式
		frame.setTitle("badapple_by_氙钬钍");
		frame1.setBounds(640, 20, 560, 575);
		frame1.setResizable(false);// 不可改变大小
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭方式
		frame1.setTitle("badapple_by_氙钬钍");
		frame.setUndecorated(true);
		frame1.setUndecorated(true);
		JTextArea are = new JTextArea();
		JTextArea are1 = new JTextArea();
		frame.add(are);
		frame1.add(are1);

		// set BG & FG 's color
		are.setBackground(Color.BLACK);
		are.setForeground(Color.WHITE);
		are1.setBackground(Color.BLACK);
		are1.setForeground(Color.WHITE);

		are.setBounds(0, 0, 560, 575);
		are.setFont(new java.awt.Font("宋体", 2, 14));
		are1.setBounds(0, 0, 560, 575);
		are1.setFont(new java.awt.Font("宋体", 2, 14));
		File file = new File("badapple2/badapple2.txt");
		File file1 = new File("badapple2/badapple6.txt");
		frame.setVisible(true);
		frame1.setVisible(true);

		// play music
		new Thread(new Runnable() {
			public void run() {
				new BasicPlayer().play(new File("badapple1.wav"), 0);
			}
		}).start();


		// 打印
		showBadApple(are, are1, file, file1);

	}

	public void showBadApple(JTextArea are, JTextArea are1, File file,
			File file1) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);// 缓存阅读
			StringBuffer sb = new StringBuffer();
			
			FileReader fr1 = new FileReader(file1);
			BufferedReader br1 = new BufferedReader(fr1);// 缓存阅读
			StringBuffer sb1 = new StringBuffer();
			try {

				int b = 0;
				int a = 0;
				while (b <= 229922) {
					b++;
					a++;

					String str = br.readLine();
					sb.append(str + "\n");
					String str2 = br1.readLine();
					sb1.append(str2 + "\n");
					if (a % 35 == 0) {

						try {

							String str1 = sb.toString();
							sb = new StringBuffer("");
							String str3 = sb1.toString();
							sb1 = new StringBuffer("");
							are.setText(str1);
							are1.setText(str3);

							Thread.sleep(30L);
//							for test
//							Thread.sleep((long) 1);

						} catch (InterruptedException e) {

							e.printStackTrace();
						}

					} 
				}
				fr.close();
				br.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new BadAppleMain();
		
		try {
			Thread.sleep(12000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.exit(0);
	}

}
