package cn.edu.zucc.takeout.itf;

import java.util.List;

import cn.edu.zucc.takeout.model.BeanCoupon;
import cn.edu.zucc.takeout.model.BeanShopkeeper;
import cn.edu.zucc.takeout.util.BaseException;

public interface ICouponManager {

	public void addcou(BeanShopkeeper shop, String coupid, Float amount, int count, String start, String end)
			throws BaseException;

	public void deletecoup(BeanCoupon coup) throws BaseException;

	public List<BeanCoupon> loadShopCoupon(BeanShopkeeper shop) throws BaseException;

}