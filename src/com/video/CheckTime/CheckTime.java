package com.video.CheckTime;

import java.text.ParseException;
import java.util.Calendar;

import com.video.Bean.User;

public class CheckTime {

	public long Chek(String time) throws ParseException {
		/*
		 * 定义一个时间对比类，把从数据库取出来的时间与现在时间做对比
		 * 然后返回VIP剩余天数
		 *
		 * */
        Calendar now = Calendar.getInstance();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
        java.util.Date NowDate;
        
        java.util.Date SqlDate= format.parse(time); //从数据库取出来的时间
        
      //现在时间
        NowDate = format.parse(
        		now.get(Calendar.YEAR)
        		+"-"+
        		now.get(Calendar.MONTH+1)
        		+"-"+
        		now.get(Calendar.DAY_OF_MONTH)
        		);

            //把数据库取出来的时间减去现在时间，然后换算成天数  
	        long day=(SqlDate.getTime()-NowDate.getTime())/(24*60*60*1000);
	        
	        return day; 
		   
		

	}

}
