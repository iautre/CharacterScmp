package CharacterScmp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class setScmp  implements ActionListener{
	//����M,P,S,C�ĸ����ͱ�������Ϊͳ��ѡ����
	static private int M=0;
	static private int S=0;
	static private int C=0;
	static private int P=0;
	static private JPanel jp=new JPanel();
	private JLabel jl=new JLabel();
	//����M,P,S,C �ĸ�ѡ��
	private JRadioButton jrbM=new JRadioButton();
	private JRadioButton jrbP=new JRadioButton();
	private JRadioButton jrbS=new JRadioButton();
	private JRadioButton jrbC=new JRadioButton();
	//ѡ���Ե��ж�������
	private GridLayout gl=new GridLayout(0,1);
	private boolean am,ap,as,ac;//��Ϊ����ǰ�ж��Ƿ�ѡ��
	
	public setScmp(int n,String m,String p,String s,String c){
		//�������
		jl.setText("��"+n+"��");
		//����ѡ��
		jrbM.setText(m);
		jrbP.setText(p);
		jrbS.setText(s);
		jrbC.setText(c);
		//��ʼ��am,ap,as,acֵΪ����ǰ�Ƿ�ѡ�У�ѡ���״̬���ڶ���֮ǰ���������򣬸��趯��֮��״̬�����Ƿ�ѡ�ж����Ϊѡ��״̬��
		am=jrbM.isSelected();
		ap=jrbP.isSelected();
		as=jrbS.isSelected();
		ac=jrbC.isSelected();
		//����ѡ��
		jrbM.addActionListener(this);
		jrbP.addActionListener(this);
		jrbS.addActionListener(this);
		jrbC.addActionListener(this);
		//���ѡ����jp
		jp.setLayout(gl);
		jp.add(jl);
		jp.add(jrbM);
		jp.add(jrbP);
		jp.add(jrbS);
		jp.add(jrbC);
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * ��д��������
	 */
	@Override
	public void actionPerformed(ActionEvent jrb) {
		//�жϼ���jrb���ĸ�
		if (jrb.getSource()==jrbM){//�������M,��ִ������
			//ѡ��ѡ��
			jrbM.setSelected(true);
			//�ж�ѡ���ڱ�����ѡ��֮ǰ�Ƿ�Ϊ��ѡ��״̬���������֮ǰΪ��ѡ��״̬���������1������ѡ��״̬amΪѡ��״̬true
			if (!am) {
				M++;
				am=true;
			}
			//�ж�p�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//�ж�s�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//�ж�c�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
			
		}else if (jrb.getSource()==jrbP){//�������P,��ִ������
			jrbP.setSelected(true);
			if (!ap) P++;
			ap=true;
			//�ж�m�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
			//�ж�s�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//�ж�c�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
		}else if (jrb.getSource()==jrbS){//�������S,��ִ������
			jrbS.setSelected(true);
			if (!as) S++;
			as=true;
			//�ж�p�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//�ж�m�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
			//�ж�c�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
		}else if(jrb.getSource()==jrbC){//�������C,��ִ������
			jrbC.setSelected(true);
			if (!ac) C++;
			ac=true;
			//�ж�p�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//�ж�s�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//�ж�m�Ƿ�ѡ�У����ѡ����ȡ��ѡ�񣬲�������1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
		}
	}
	/*
	 * �Ծ�̬��ʽ�������ս������ֹ�ٶ�δ�������ʱ���������ʼ���Ľ��ֵ���½���޷�����ͳ�ơ�
	 */
	static public String getResult(){
		//��ͳ�ƽ���ŵ�����������н�������
		int[] count={M,P,S,C};
		for (int i=0;i<count.length-1;i++){
			for (int j=0;j<count.length-1-i;j++){
				int temp=0;
				if (count[j]<count[j+1]){
					temp=count[j];
					count[j]=count[j+1];
					count[j+1]=temp;
				}
			}
		}//��������������һ��ֵ�������ֵ
		/*
		 * ����ͳ������жϽ��
		 */
		//���ύǰ�ж�ѡ���Ƿ�ѡ
		if (M==0 && P==0&&S==0&&C==0)return "��ѡ������ύ";
		//���ύǰ�ж�ѡ���Ƿ�ѡ��
		else if (M+P+S+C<loadData.getCount()) return "������"+(loadData.getCount()-M-P-S-C)+"��û��ѡ����ȫ��ѡ�����ύ";
		
		else if(count[0]==count[1])return "���Ը��ӣ���ϵͳ�޷����в���";//������ѡ��ͬʱ��࣬Ϊ�����Ը�
		else if(count[0]==M)return "����M�ͣ�������M�͡���ť�鿴�Ը����";
		else if(count[0]==P)return "����P�ͣ�������P�͡���ť�鿴�Ը����";
		else if(count[0]==S)return "����S�ͣ�������S�͡���ť�鿴�Ը����";
		else return "����C�ͣ�������C�͡���ť�鿴�Ը����";
		
	}
	/*
	 * ��̬��ʽ���������JPanel
	 */
	static public JPanel getJP(){
		return jp;
	}
	
	
}
