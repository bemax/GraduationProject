package todo.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

	//年・月・日・時間・分・秒の変数（数値型）
	static int y, mo, d, h, mi, s;

	//年・月・日・時間・分・秒の変数（文字型）
	String year, month, day, hour, minute, second;

	//﻿○○年○月○日○時○分○秒
	String ymdhms;


	//空のコンストラクタ
	public Log(){

	}

	//追加・更新・削除かを判断してログを書き込む
	public void output(int iud, String tablename){

		try{
			File file = new File("test.txt");

			FileWriter filewriter = new FileWriter(file, true);

			if (file.exists()){

				//数値型を文字型へ変換
				year = String.valueOf(y);
				month = String.valueOf(mo);
				day = String.valueOf(d);
				hour = String.valueOf(h);
				minute = String.valueOf(mi);
				second = String.valueOf(s);

				ymdhms = year + "年" + month + "月" + day + "日" + hour + "時"+ minute + "分" + second + "秒";

			}else{
				file.createNewFile();
			}

			//追加の場合
			if(iud == 0){

				if(tablename.equals("社員")){
					filewriter.write(ymdhms + " " + tablename + " を 追加 しました\r\n");

				}else{
					filewriter.write(ymdhms + " "  + tablename + " を 追加 しました\r\n");
				}


			}

			//更新の場合
			else if(iud == 1){

				if(tablename.equals("社員")){
					filewriter.write(ymdhms + " "  + tablename + " を 更新 しました\r\n");

				}else{
					filewriter.write(ymdhms + " "  + tablename + " を 更新 しました\r\n");
				}
			}

			//削除の場合
			else if(iud == 2){

				if(tablename.equals("社員")){
					filewriter.write(ymdhms + " "  + tablename + " を 削除 しました\r\n");

				}else{
					filewriter.write(ymdhms + " "  + tablename + " を 削除 しました\r\n");
				}
			}

			filewriter.close();

		}catch(IOException e){
			System.out.println(e);
		}
	}


	void insertLog(String tableName, String[] clumName, String[] record){

	}

	void updateLog(String tableName, String[] key, String[] clumName, String[] before, String[] after){

	}

	void deletelog(String tablename, String[] clumName, String[] record){

	}

	void input(){
		try{
			File file = new File("test.txt");


			BufferedReader br = new BufferedReader(new FileReader(file));

			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}

			br.close();

		}catch(IOException e){
			System.out.println(e);
		}
	}
}
