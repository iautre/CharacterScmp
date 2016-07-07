package CharacterScmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class loadData {
	private File data=new File("Data"+File.separator+"scmpData.txt");//数据目录为当前Project项目下的Data目录下scmpData.txt文件
	private Reader reader=null;
	private StringBuffer scmpData=new StringBuffer();
	static private int count=0;
	/*
	 * 构造函数中添加读取文件功能，再新建对象时就读取文件，并把文件内容放到指定字符串变量中
	 */
	public loadData(){
		try {
			reader=new FileReader(data);
			int b=0;
			while ((b=reader.read())!=-1){
				//把文件内容读取添加到字符串scmpData中
				scmpData.append((char)b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用统计题目数量，进行统计
		countScmp();	
	}
	/*
	 * 以静态方式输出题目数量，方便外部调用
	 */
	static public int getCount(){
		return count;
	}
	/*
	 * 进行统计文件中题目数量
	 */
	public void countScmp(){
		for (int i=0;i<scmpData.length();i++){
			if (scmpData.charAt(i)=='M'){
				count++;
			}
		}
	}
	/*
	 * 格式化字符串，并把字符串中每个选项添加加到对象setScmp，
	 * 添加一个组选项后，并删除此组选项，以便于下一组选项的截取与添加
	 */
	public void loadReader(){
		for (int i=1;i<=count;i++){
		new setScmp(
				i,
				scmpData.substring(scmpData.indexOf("M"), scmpData.indexOf("\n",scmpData.indexOf("M"))),
				scmpData.substring(scmpData.indexOf("P"), scmpData.indexOf("\n",scmpData.indexOf("P"))),
				scmpData.substring(scmpData.indexOf("S"), scmpData.indexOf("\n",scmpData.indexOf("S"))),
				scmpData.substring(scmpData.indexOf("C"), scmpData.indexOf("\n",scmpData.indexOf("C")))
				);
		scmpData.delete(scmpData.indexOf("M"), scmpData.indexOf("\n",scmpData.indexOf("M")));
		scmpData.delete(scmpData.indexOf("P"), scmpData.indexOf("\n",scmpData.indexOf("P")));
		scmpData.delete(scmpData.indexOf("S"), scmpData.indexOf("\n",scmpData.indexOf("S")));
		scmpData.delete(scmpData.indexOf("C"), scmpData.indexOf("\n",scmpData.indexOf("C")));
		}
	}
}
