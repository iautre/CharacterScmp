package CharacterScmp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

public class scmp{
	private JFrame jf=new JFrame("�Ը�scmp����");
	private JButton jb=new JButton("�ύ");
	private JButton jbM=new JButton("M��");
	private JButton jbP=new JButton("P��");
	private JButton jbS=new JButton("S��");
	private JButton jbC=new JButton("C��");
	private JPanel jp=new JPanel();//��������
	private JScrollPane jsp=new JScrollPane();
	private JTextArea jta=new JTextArea();
	private JScrollPane jsp2;//����ѡ�����ɹ������
	GridLayout gl=new GridLayout(5,1);//��ť���У�1��5��
	public scmp(){
		//�����������ݶ���
		loadData ld=new loadData();
		//���õ������ݷ���
		ld.loadReader();
		//�����ύ��ť
		jb.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//�����ı���ʾ
						jta.setText(setScmp.getResult());	
					}
				}
				);
		jbM.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//����M�ı���ʾ
						jta.setText("�����ͣ�M�ͣ��Ը������\n " +
							"�������ࡢ���塢��ò��ì�ܣ�\n " +
							"�罻�������׽����ѣ����ύ��ÿһ�����Ƿǳ��õ����ѣ�������˵�������������ˡ�\n " +
							"��У�����������񡢽�ʡ�����С�����\n" +
							"���������ڱ��Դʻ�����������֯����ǿ���������ã��Ż����ڡ�\n" +
							"�������谭�㣺\n" +
							"1������������ 2���Բ��λ� ��3������������");	
					}
				}
				);
		jbS.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//����S�ı���ʾ
						jta.setText("�����ͣ�S�ͣ��Ը������\n " +
							"���������ֹۡ����ԡ������֣�\n " +
							"�罻��ϲ��Ⱥ�ӡ����Ѷ࣬���飬ϲ�������ˣ�����������\n " +
							"��У��Ʊ䣬�������ʣ������ױ����������ǳ�\n" +
							"���������������кܸߵ����£��һ�����������и�Ⱦ�����ܹ�Ӱ���ܱߵ��ˡ�\n" +
							"�������谭�㣺\n" +
							"1�����ж����� 2��������� ��3������Ϊ���ģ� 4����ע����䣻5���仯�޳���6�������������졣");	
					}
				}
				);
		jbP.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//����P�ı���ʾ
						jta.setText("��ƽ�ͣ�P�ͣ��Ը������\n " +
							"����������ͣ�ϲ����������·��������΢Ц������������ϲ���仯���ٷ�ŭ��\n " +
							"�罻�������Թ��ߣ���͡����Ѷ࣬ϲ���������˳��̡�\n " +
							"��У�ϸ������ì�ܣ����ɡ����������ȶ���\n" +
							"������ϲ�����˺����������Խϲ�ϱ�������ѹ���Լ���������\n" +
							"��ƽ���谭�㣺\n" +
							"1���ù��ҹ��� 2��û������ ��\n");	
					}
				}
				);
		jbC.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//����C�ı���ʾ
						jta.setText("�����ͣ�C�ͣ��Ը������\n" +
							"���󣺹����ͣ��۾�����������·��粽��֫�嶯���ٵ��ᶨ������ϲ����ݣ�\n " +
							"�罻����ϲ��˵��������ִ����ּ�������ʹ����Ҳ����Ǹ��ִ�źö�������Ҫ���Ѱ�����\n " +
							"��У����鷳��ע�ط���ǿ����ֵ����ϸ�ڣ����ж����ѷ��ɣ�ȱ��ͬ���ġ�\n" +
							"�����������쵼�Ա����ϸ�Ҫ�󣬵����Լ�����ν�����д�������רע�Ҷ������кö����������\n" +
							"�������谭�㣺\n" +
							"1����ʤ��ǿ��2��һ����� ��");	
					}
				}
				);
		//ѡ�������ʾ
		jsp2=new JScrollPane(setScmp.getJP());
		jsp2.setBounds(20, 20, 500, 500);
		jf.add(jsp2);
		//��ť��ʾ,�ύ��ť��M,P,S,C��ť
		jp.setLayout(gl);
		jp.add(jb);
		jp.add(jbM);
		jp.add(jbP);
		jp.add(jbS);
		jp.add(jbC);
		jp.setBounds(20, 540,80, 200);
		jf.add(jp);
		//Ĭ��������ʾ
		jta.setText("�Ը���ԣ�������һ��"+loadData.getCount()+"�⣬ÿ��ֻ��ѡ��һ�ȫ��ѡ����ύ�����ɷ��������Ը�");
		jta.setLineWrap(true);//����
		jta.setBounds(120, 540,380, 200);
		jsp.add(jta);
		jsp.setBounds(120, 540,380, 200);
		jf.add(jsp);
		jf.setBounds(300, 50, 540, 800);
		//�ڹرս���ʱͬʱ�رս���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);//���ڲ�������
		jf.setVisible(true);
		
	}
	
}

