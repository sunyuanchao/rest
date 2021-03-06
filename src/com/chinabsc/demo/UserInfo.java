package com.chinabsc.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("userInfoService")
public class UserInfo {

	
	@GET
	@Path("/name/{i}")
	@Produces(MediaType.TEXT_XML)
	public String userName(@PathParam("i")String i){
		 String name = i;
		 return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}
	
	@GET
	@Path("/age/{j}")
	@Produces(MediaType.TEXT_XML)
	public String userAge(@PathParam("j") int j){
		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}
	
	@GET
	@Path("/address/{k}")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=UTF-8")  
	public String userAddress(@PathParam("k") String k){
		String address = k;
		return "{\""+address+"\":\"中国北京\",\"quyu\":\"昌平区\"}";
	}
	
	
	
}
