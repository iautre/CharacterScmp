package CharacterScmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class loadData {
	private File data=new File("Data"+File.separator+"scmpData.txt");//����Ŀ¼Ϊ��ǰProject��Ŀ�µ�DataĿ¼��scmpData.txt�ļ�
	private Reader reader=null;
	private StringBuffer scmpData=new StringBuffer();
	static private int count=0;
	/*
	 * ���캯������Ӷ�ȡ�ļ����ܣ����½�����ʱ�Ͷ�ȡ�ļ��������ļ����ݷŵ�ָ���ַ���������
	 */
	public loadData(){
		try {
			reader=new FileReader(data);
			int b=0;
			while ((b=reader.read())!=-1){
				//���ļ����ݶ�ȡ��ӵ��ַ���scmpData��
				scmpData.append((char)b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ͳ����Ŀ����������ͳ��
		countScmp();	
	}
	/*
	 * �Ծ�̬��ʽ�����Ŀ�����������ⲿ����
	 */
	static public int getCount(){
		return count;
	}
	/*
	 * ����ͳ���ļ�����Ŀ����
	 */
	public void countScmp(){
		for (int i=0;i<scmpData.length();i++){
			if (scmpData.charAt(i)=='M'){
				count++;
			}
		}
	}
	/*
	 * ��ʽ���ַ����������ַ�����ÿ��ѡ����Ӽӵ�����setScmp��
	 * ���һ����ѡ��󣬲�ɾ������ѡ��Ա�����һ��ѡ��Ľ�ȡ�����
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
