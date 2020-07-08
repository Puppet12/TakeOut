package cn.edu.zucc.takeout.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeout.TakeOutUtil;
import cn.edu.zucc.takeout.model.BeanCoupon;
import cn.edu.zucc.takeout.model.BeanDiscount;
import cn.edu.zucc.takeout.model.BeanPreferential;
import cn.edu.zucc.takeout.model.BeanProduct;
import cn.edu.zucc.takeout.model.BeanShopkeeper;
import cn.edu.zucc.takeout.util.BaseException;

public class FrmMainManager_Shopkeeper extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menubar=new JMenuBar();
	
	private JPanel toolBar=new JPanel();
	
	private JButton btnshopadd=new JButton("添加商家");
    private JButton btnshopdelete=new JButton("删除商家");
    private JButton btnproadd=new JButton("添加商品");
    private JButton btnprodelete=new JButton("删除商品");
    private JButton btncouadd=new JButton("添加优惠券");
    private JButton btncoudelete=new JButton("删除优惠券");
    private JButton btnmanadd=new JButton("添加满减方案");
    private JButton btnmandelete=new JButton("删除满减方案");
	
	private Object tblShopTitle[]=BeanShopkeeper.tableTitles;
	private Object tblShopData[][];
	DefaultTableModel tabShopModel=new DefaultTableModel();
	private JTable dataTableShop=new JTable(tabShopModel);
	
	private Object tblProTitle[]=BeanProduct.tableTitles;
	private Object tblProData[][];
	DefaultTableModel tabProModel=new DefaultTableModel();
	private JTable dataTablePro=new JTable(tabProModel);
	
	private Object tblCouTitle[]=BeanCoupon.tableTitles;
	private Object tblCouData[][];
	DefaultTableModel tabCouModel=new DefaultTableModel();
	private JTable dataTableCou=new JTable(tabCouModel);
	
	private Object tblManTitle[]=BeanPreferential.tableTitles;
	private Object tblManData[][];
	DefaultTableModel tabManModel=new DefaultTableModel();
	private JTable dataTableMan=new JTable(tabManModel);
	
	private BeanShopkeeper curShop=null;
	List<BeanShopkeeper> allShop=null;
	private BeanProduct curProduct=null;
	List<BeanProduct> allProduct=null;
	private BeanCoupon curCoupon=null;
	List<BeanCoupon> allCoupon=null;
	private BeanPreferential curMan=null;
	List<BeanPreferential> allMan=null;
	
	List<BeanProduct> shopPros=null;
	List<BeanCoupon> shopCous=null;
	List<BeanPreferential> shopMans=null;
	public static BeanShopkeeper shop=null;
	
	private void reloadShopTable(){
		try {
			allShop=TakeOutUtil.shopkeeperManager.loadAll();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblShopData =  new Object[allShop.size()][BeanShopkeeper.tableTitles.length];
		for(int i=0;i<allShop.size();i++){
			for(int j=0;j<BeanShopkeeper.tableTitles.length;j++)
				tblShopData[i][j]=allShop.get(i).getCell(j);
		}
		tabShopModel.setDataVector(tblShopData,tblShopTitle);
		this.dataTableShop.validate();
		this.dataTableShop.repaint();
	}
	
	private void reloadProTable(){
		try {
			allProduct=TakeOutUtil.productManager.loadShopProducts(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProData =  new Object[allProduct.size()][BeanProduct.tableTitles.length];
		for(int i=0;i<allProduct.size();i++){
			for(int j=0;j<BeanProduct.tableTitles.length;j++)
				tblProData[i][j]=allProduct.get(i).getCell(j);
		}
		tabProModel.setDataVector(tblProData,tblProTitle);
		this.dataTablePro.validate();
		this.dataTablePro.repaint();
	}
	
	private void reloadCouTable(){
		try {
			allCoupon=TakeOutUtil.couponManager.loadShopCoupon(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblCouData =  new Object[allCoupon.size()][BeanCoupon.tableTitles.length];
		for(int i=0;i<allCoupon.size();i++){
			for(int j=0;j<BeanCoupon.tableTitles.length;j++)
				tblCouData[i][j]=allCoupon.get(i).getCell(j);
		}
		tabProModel.setDataVector(tblCouData,tblCouTitle);
		this.dataTableCou.validate();
		this.dataTableCou.repaint();
	}
	
	private void reloadManTable(){
		try {
			allCoupon=TakeOutUtil.couponManager.loadShopCoupon(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblCouData =  new Object[allCoupon.size()][BeanCoupon.tableTitles.length];
		for(int i=0;i<allCoupon.size();i++){
			for(int j=0;j<BeanCoupon.tableTitles.length;j++)
				tblCouData[i][j]=allCoupon.get(i).getCell(j);
		}
		tabProModel.setDataVector(tblCouData,tblCouTitle);
		this.dataTableCou.validate();
		this.dataTableCou.repaint();
	}
	
	private void reloadShopProTabel(int shopIdx){
		if(shopIdx<0) return;
		curShop=allShop.get(shopIdx);
		try {
			shopPros=TakeOutUtil.productManager.loadShopProducts(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProData =new Object[shopPros.size()][tblProTitle.length];
		for(int i=0;i<shopPros.size();i++){
			for(int j=0;j<tblProTitle.length;j++)
				tblProData[i][j]=shopPros.get(i).getCell(j);
		}
		
		tabProModel.setDataVector(tblProData,tblProTitle);
		this.dataTablePro.validate();
		this.dataTablePro.repaint();
	}
	
	private void reloadShopManTabel(int shopIdx){
		if(shopIdx<0) return;
		curShop=allShop.get(shopIdx);
		try {
			shopMans=TakeOutUtil.couponManager.loadShopMan(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProData =new Object[shopPros.size()][tblProTitle.length];
		for(int i=0;i<shopPros.size();i++){
			for(int j=0;j<tblProTitle.length;j++)
				tblProData[i][j]=shopPros.get(i).getCell(j);
		}
		
		tabProModel.setDataVector(tblProData,tblProTitle);
		this.dataTablePro.validate();
		this.dataTablePro.repaint();
	}
	
	private void reloadShopCouTabel(int shopIdx){
		if(shopIdx<0) return;
		curShop=allShop.get(shopIdx);
		try {
			shopCous=TakeOutUtil.couponManager.loadShopCoupon(curShop);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProData =new Object[shopPros.size()][tblProTitle.length];
		for(int i=0;i<shopPros.size();i++){
			for(int j=0;j<tblProTitle.length;j++)
				tblProData[i][j]=shopPros.get(i).getCell(j);
		}
		
		tabProModel.setDataVector(tblProData,tblProTitle);
		this.dataTablePro.validate();
		this.dataTablePro.repaint();
	}
	
	public FrmMainManager_Shopkeeper(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("商家管理");
		
		this.btnshopadd.addActionListener(this);
	    this.btnshopdelete.addActionListener(this);
	    this.btnproadd.addActionListener(this);
	    this.btnprodelete.addActionListener(this);
	    
	    toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menubar.add(toolBar);
	    toolBar.add(btnshopadd);
	    toolBar.add(btnshopdelete);
	    toolBar.add(btnproadd);
	    toolBar.add(btnprodelete);
	    toolBar.add(btncouadd);
	    toolBar.add(btncoudelete);
	    toolBar.add(btnmanadd);
	    toolBar.add(btnmandelete);
	    this.setJMenuBar(menubar);
	    
	    this.dataTableShop.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmMainManager_Shopkeeper.this.dataTableShop.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMainManager_Shopkeeper.this.reloadShopProTabel(i);
			}
	    	
	    });

	    JPanel right=new JPanel(new BorderLayout());
	    JPanel rightSouth=new JPanel(new BorderLayout());
	    this.getContentPane().add(new JScrollPane(this.dataTableShop), BorderLayout.WEST);
	    this.getContentPane().add(right, BorderLayout.CENTER);
	    right.add(new JScrollPane(this.dataTablePro), BorderLayout.NORTH);
	    right.add(rightSouth, BorderLayout.SOUTH);
	    rightSouth.add(new JScrollPane(this.dataTableCou), BorderLayout.WEST);
	    rightSouth.add(new JScrollPane(this.dataTableMan), BorderLayout.CENTER);
	    
	    this.reloadShopTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btnshopadd){
			FrmShopkeeperAdd dlg=new FrmShopkeeperAdd(this,"添加商家",true);
			dlg.setVisible(true);
			this.reloadShopTable();
		    this.reloadProTable();
		}else if(e.getSource()==this.btnshopdelete){
			int i=FrmMainManager_Shopkeeper.this.dataTableShop.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择商家", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				curShop=allShop.get(i);
			}
			try {
				TakeOutUtil.shopkeeperManager.deleteshop(this.curShop);
				this.reloadShopTable();
			    this.reloadProTable();
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}else if(e.getSource()==this.btnproadd){
			int i=FrmMainManager_Shopkeeper.this.dataTableShop.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择商家", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				curShop=allShop.get(i);
				shop=curShop;
			}
			FrmAddProduct dlg=new FrmAddProduct(this,"添加商品",true);
			dlg.setVisible(true);
			this.reloadShopTable();
		    this.reloadProTable();
		}else if(e.getSource()==this.btnprodelete){
			int i=FrmMainManager_Shopkeeper.this.dataTablePro.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "请选择商品", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				curProduct=allProduct.get(i);
			}
			try {
				TakeOutUtil.productManager.deleteProduct(this.curProduct);
				this.reloadShopTable();
			    this.reloadProTable();
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
	}
  
}
