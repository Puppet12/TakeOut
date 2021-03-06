package cn.edu.zucc.takeout.itf;

import java.util.List;

import cn.edu.zucc.takeout.model.BeanRider;
import cn.edu.zucc.takeout.util.BaseException;

public interface IRiderManager {
	
	public BeanRider addrider(String ridername) throws BaseException;
	
	public void deleterider(BeanRider rider) throws BaseException;
	
	public List<BeanRider> loadAll() throws BaseException;

	public void modifyrider(BeanRider rider, String name) throws BaseException;

}
