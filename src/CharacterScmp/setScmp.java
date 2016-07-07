package CharacterScmp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class setScmp  implements ActionListener{
	//定义M,P,S,C四个整型变量，作为统计选项结果
	static private int M=0;
	static private int S=0;
	static private int C=0;
	static private int P=0;
	static private JPanel jp=new JPanel();
	private JLabel jl=new JLabel();
	//定义M,P,S,C 四个选项
	private JRadioButton jrbM=new JRadioButton();
	private JRadioButton jrbP=new JRadioButton();
	private JRadioButton jrbS=new JRadioButton();
	private JRadioButton jrbC=new JRadioButton();
	//选项以单行多列排列
	private GridLayout gl=new GridLayout(0,1);
	private boolean am,ap,as,ac;//作为监听前判断是否被选定
	
	public setScmp(int n,String m,String p,String s,String c){
		//设置题号
		jl.setText("第"+n+"题");
		//设置选项
		jrbM.setText(m);
		jrbP.setText(p);
		jrbS.setText(s);
		jrbC.setText(c);
		//初始化am,ap,as,ac值为监听前是否被选中，选项的状态得在动作之前监听，否则，赋予动作之后状态不管是否选中都会变为选中状态。
		am=jrbM.isSelected();
		ap=jrbP.isSelected();
		as=jrbS.isSelected();
		ac=jrbC.isSelected();
		//监听选项
		jrbM.addActionListener(this);
		jrbP.addActionListener(this);
		jrbS.addActionListener(this);
		jrbC.addActionListener(this);
		//添加选项到面板jp
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
	 * 重写监听方法
	 */
	@Override
	public void actionPerformed(ActionEvent jrb) {
		//判断监听jrb是哪个
		if (jrb.getSource()==jrbM){//如果监听M,则执行下面
			//选中选项
			jrbM.setSelected(true);
			//判断选项在被本次选择之前是否为非选中状态，如果本次之前为非选中状态，则计数加1，并设选中状态am为选中状态true
			if (!am) {
				M++;
				am=true;
			}
			//判断p是否被选中，如果选中则取消选择，并计数减1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//判断s是否被选中，如果选中则取消选择，并计数减1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//判断c是否被选中，如果选中则取消选择，并计数减1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
			
		}else if (jrb.getSource()==jrbP){//如果监听P,则执行下面
			jrbP.setSelected(true);
			if (!ap) P++;
			ap=true;
			//判断m是否被选中，如果选中则取消选择，并计数减1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
			//判断s是否被选中，如果选中则取消选择，并计数减1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//判断c是否被选中，如果选中则取消选择，并计数减1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
		}else if (jrb.getSource()==jrbS){//如果监听S,则执行下面
			jrbS.setSelected(true);
			if (!as) S++;
			as=true;
			//判断p是否被选中，如果选中则取消选择，并计数减1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//判断m是否被选中，如果选中则取消选择，并计数减1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
			//判断c是否被选中，如果选中则取消选择，并计数减1
			if (jrbC.isSelected()){
				jrbC.setSelected(false);
				C--;
				ac=false;
			}
		}else if(jrb.getSource()==jrbC){//如果监听C,则执行下面
			jrbC.setSelected(true);
			if (!ac) C++;
			ac=true;
			//判断p是否被选中，如果选中则取消选择，并计数减1
			if (jrbP.isSelected()){
				jrbP.setSelected(false);
				P--;
				ap=false;
			}
			//判断s是否被选中，如果选中则取消选择，并计数减1
			if (jrbS.isSelected()){
				jrbS.setSelected(false);
				S--;
				as=false;
			}
			//判断m是否被选中，如果选中则取消选择，并计数减1
			if (jrbM.isSelected()){
				jrbM.setSelected(false);
				M--;
				am=false;
			}
		}
	}
	/*
	 * 以静态方式返回最终结果，防止再多次创建对象时产生多个初始化的结果值导致结果无法正常统计。
	 */
	static public String getResult(){
		//把统计结果放到数组里，并进行降序排序
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
		}//降序排序后，数组第一个值就是最大值
		/*
		 * 根据统计情况判断结果
		 */
		//在提交前判断选项是否被选
		if (M==0 && P==0&&S==0&&C==0)return "请选择后再提交";
		//在提交前判断选项是否被选完
		else if (M+P+S+C<loadData.getCount()) return "您还有"+(loadData.getCount()-M-P-S-C)+"项没有选择，请全部选完再提交";
		
		else if(count[0]==count[1])return "您性格复杂，本系统无法进行测试";//结果多个选项同时最多，为多重性格
		else if(count[0]==M)return "您是M型，请点击”M型“按钮查看性格情况";
		else if(count[0]==P)return "您是P型，请点击”P型“按钮查看性格情况";
		else if(count[0]==S)return "您是S型，请点击”S型“按钮查看性格情况";
		else return "您是C型，请点击”C型“按钮查看性格情况";
		
	}
	/*
	 * 静态方式返回类变量JPanel
	 */
	static public JPanel getJP(){
		return jp;
	}
	
	
}
