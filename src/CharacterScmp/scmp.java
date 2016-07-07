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
	private JFrame jf=new JFrame("性格scmp测试");
	private JButton jb=new JButton("提交");
	private JButton jbM=new JButton("M型");
	private JButton jbP=new JButton("P型");
	private JButton jbS=new JButton("S型");
	private JButton jbC=new JButton("C型");
	private JPanel jp=new JPanel();//结果区面板
	private JScrollPane jsp=new JScrollPane();
	private JTextArea jta=new JTextArea();
	private JScrollPane jsp2;//定义选项区可滚动面板
	GridLayout gl=new GridLayout(5,1);//按钮排列，1列5行
	public scmp(){
		//创建导入数据对象
		loadData ld=new loadData();
		//调用导入数据方法
		ld.loadReader();
		//监听提交按钮
		jb.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//设置文本显示
						jta.setText(setScmp.getResult());	
					}
				}
				);
		jbM.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//设置M文本显示
						jta.setText("完美型（M型）性格分析：\n " +
							"表象：严肃、得体、礼貌、矛盾；\n " +
							"社交：不轻易交朋友，但结交的每一个都是非常好的朋友，先想再说，不爱赞美他人。\n " +
							"情感：善于料理家务、节省、敏感、悲观\n" +
							"能力：擅于表达，言词机敏，理解和组织能力强，记忆力好，才华出众。\n" +
							"完美型阻碍点：\n" +
							"1）容易抑郁； 2）自惭形秽 ；3）拖拖拉拉。");	
					}
				}
				);
		jbS.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//设置S文本显示
						jta.setText("活泼型（S型）性格分析：\n " +
							"表象：外向、乐观、多言、爱表现；\n " +
							"社交：喜欢群居、朋友多，热情，喜欢赞美人，易忘人名。\n " +
							"情感：善变，最求新鲜，情绪易被调动，不记仇\n" +
							"能力：对事总是有很高的兴致，且活力和热情具有感染力，能够影响周边的人。\n" +
							"活泼型阻碍点：\n" +
							"1）有行动力； 2）言语过多 ；3）自我为中心； 4）不注意记忆；5）变化无常；6）无条理，不成熟。");	
					}
				}
				);
		jbP.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//设置P文本显示
						jta.setText("和平型（P型）性格分析：\n " +
							"表象：脸部祥和，喜好倾听，走路缓慢，爱微笑，动作缓慢不喜欢变化，少发怒；\n " +
							"社交：乐做旁观者，随和、朋友多，喜爱讨论他人长短。\n " +
							"情感：细化避免矛盾，自律、自制情绪稳定；\n" +
							"能力：喜欢与人合作，自主性较差，较被动，易压抑自己的能力。\n" +
							"和平型阻碍点：\n" +
							"1）得过且过； 2）没有主见 ；\n");	
					}
				}
				);
		jbC.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//设置C文本显示
						jta.setText("力量型（C型）性格分析：\n" +
							"表象：工作型，眼睛炯炯有神，走路大跨步，肢体动作少但坚定有力，喜欢快捷；\n " +
							"社交：不喜欢说话，爱争执，坚持己见，即使错了也不道歉，执着好动，不需要朋友帮助。\n " +
							"情感：性情烦躁注重方向，强调价值，轻细节，多行动，难放松，缺乏同情心。\n" +
							"能力：天生领导对别人严格要求，但对自己无所谓，具有创造力，专注且对事物有好恶分明的倾向。\n" +
							"力量型阻碍点：\n" +
							"1）好胜心强；2）一意孤行 。");	
					}
				}
				);
		//选项面板显示
		jsp2=new JScrollPane(setScmp.getJP());
		jsp2.setBounds(20, 20, 500, 500);
		jf.add(jsp2);
		//按钮显示,提交按钮，M,P,S,C按钮
		jp.setLayout(gl);
		jp.add(jb);
		jp.add(jbM);
		jp.add(jbP);
		jp.add(jbS);
		jp.add(jbC);
		jp.setBounds(20, 540,80, 200);
		jf.add(jp);
		//默认文字显示
		jta.setText("性格测试，本测试一共"+loadData.getCount()+"题，每题只能选择一项，全部选完后提交，即可分析您的性格。");
		jta.setLineWrap(true);//换行
		jta.setBounds(120, 540,380, 200);
		jsp.add(jta);
		jsp.setBounds(120, 540,380, 200);
		jf.add(jsp);
		jf.setBounds(300, 50, 540, 800);
		//在关闭界面时同时关闭进程
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);//窗口不能拉伸
		jf.setVisible(true);
		
	}
	
}

