package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import jdk.nashorn.internal.scripts.JO;
import sun.net.www.content.image.jpeg;

/**
 * @date :2016. 6. 30.
 * @author :HyunWoo Lee
 * @file :FileEx.java
 * @story :
 */

public class FileEx {
	public static void main(String[] args) {
		String fileName = "C:\\Users\\hb2011\\workspace\\";
		File file = null;
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		String msg = "";
		try {
			while (true) {
				switch (JOptionPane.showInputDialog("1.생성 2.쓰기 3.읽기 4.수정 5.삭제 0.종료")) {
				case "1":
					file = new File(fileName+JOptionPane.showInputDialog("파일명")+".txt");
					fw = new FileWriter(file,true);
					fw.close();
					break;
				case "2":
					fw = new FileWriter(file,true);
					bw = new BufferedWriter(fw);
					bw.write(JOptionPane.showInputDialog("메시지"));
					bw.newLine();
					bw.flush();
					break;
				case "3":
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					StringBuffer sb = new StringBuffer();
					while((msg = br.readLine())!=null){
						sb.append(msg+"\n");
					}
					JOptionPane.showMessageDialog(null, sb.toString());
					break;
				case "4":
					String updateFileName = JOptionPane.showInputDialog("변경 파일명");
					File updateFile = new File(fileName+updateFileName+".txt");
					fw = new FileWriter(updateFile,false);
					bw = new BufferedWriter(fw);
					msg = JOptionPane.showInputDialog("수정메시지");
					bw.write(msg);
					bw.flush();
					break;
				case "5":
					String delFile = JOptionPane.showInputDialog("삭제 파일명");
					File dFile = new File(fileName+delFile+".txt");
					dFile.delete();
					break;
				case "0":
					br.close();
					bw.close();
					fw.close();
					fr.close();
					return;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try{
				fw.flush();
				bw.flush();
				br.close();
				bw.close();
				fw.close();
				fr.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
