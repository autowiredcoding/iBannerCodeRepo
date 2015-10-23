package com.ibanner.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibannerify.external.IBannerify;


/**
 * Request Entry Controller
 * @author shyam
 *
 */
public class BannerifyController {
	
	@Autowired
	IBannerify iBannerify;
	
	@RequestMapping(value = "/banner", method = RequestMethod.GET)
	@ResponseBody
	void getBanner(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException{
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
	    httpServletResponse.setContentType("image/jpeg");
	    httpServletResponse.getOutputStream().write(IOUtils.toByteArray(iBannerify.getBannerImage()));
	}
}
