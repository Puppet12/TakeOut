package cn.edu.zucc.takeout.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeout.TakeOutUtil;
import cn.edu.zucc.takeout.model.BeanShopkeeper;
import cn.edu.zucc.takeout.util.BaseException;

public class FrmCouponAdd extends JDialog implements ActionListener{
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelAmount = new JLabel("优惠金额：");
	private JTextField edtAmount = new JTextField(20);
	private JLabel labelDiscount = new JLabel("集单要求：");
	private JTextField edtDiscount = new JTextField(20);
	private JLabel labelStart = new JLabel("开始日期：");
	private JTextField edtStart = new JTextField(20);
	private JLabel labelEnd = new JLabel("截止日期：");
	private JTextField edtEnd = new JTextField(20);
	
	public FrmCouponAdd(JFrame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelAmount);
		workPane.add(edtAmount);
		workPane.add(labelDiscount);
		workPane.add(edtDiscount);
		workPane.add(labelStart);
		workPane.add(edtStart);
		workPane.add(labelEnd);
		workPane.add(edtEnd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 180);
		
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			BeanShopkeeper shop=null;
			shop=new FrmMainManager_Shopkeeper().shop;
			float amount=Float.parseFloat(this.edtAmount.getText());
			int count=Integer.parseInt(this.edtDiscount.getText());
			String start=this.edtStart.getText();
			String end=this.edtEnd.getText();
			try {
				TakeOutUtil.couponManager.addcou(shop, amount, count, start, end);;
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
	}

}
