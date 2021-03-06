package cn.edu.zucc.takeout.model;

import java.util.Date;

public class BeanProductorder {
	public static final String[] tableTitles={"订单编号","商家编号","满减编号","优惠券编号","地址编号","骑手编号","原始价格","最终价格","下单时间","要求时间","订单状态"};
	public String getCell(int col){
		if(col==0) return order_id+"";
		else if(col==1) return shop_id+"";
		else if(col==2) return pre_id+"";
		else if(col==3) return coup_id+"";
		else if(col==4) return add_id+"";
		else if(col==5) return rider_id+"";
		else if(col==6) return originprice+"";
		else if(col==7) return finalprice+"";
		else if(col==8) return starttime+"";
		else if(col==9) return requiretime+"";
		else if(col==10) return orderstate+"";
		else return "";
	}
	private int order_id;
	private int pre_id;
	private int add_id;
	private int cust_id;
	private int shop_id;
	private int coup_id;
	private int rider_id;
	private float originprice;
	private float finalprice;
	private Date starttime;
	private Date requiretime;
	private String orderstate;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getPre_id() {
		return pre_id;
	}
	public void setPre_id(int pre_id) {
		this.pre_id = pre_id;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getCoup_id() {
		return coup_id;
	}
	public void setCoup_id(int coup_id) {
		this.coup_id = coup_id;
	}
	public int getRider_id() {
		return rider_id;
	}
	public void setRider_id(int rider_id) {
		this.rider_id = rider_id;
	}
	public float getOriginprice() {
		return originprice;
	}
	public void setOriginprice(float originprice) {
		this.originprice = originprice;
	}
	public float getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(float finalprice) {
		this.finalprice = finalprice;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getRequiretime() {
		return requiretime;
	}
	public void setRequiretime(Date requiretime) {
		this.requiretime = requiretime;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
}
