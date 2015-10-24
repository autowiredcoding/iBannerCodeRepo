package com.ibannerify.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibannerify.external.IBannerify;


/**
 * Request Entry Controller
 * @author Shyam Ramath
 */
@RequestMapping("/banner")
@Controller
public class BannerifyController {
	
	@Autowired
	IBannerify iBannerify;
	
	/**
	 * 
	 * @param request
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	@ResponseBody
	void getBanner(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException{
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
	    httpServletResponse.setContentType("image/jpeg");
	    httpServletResponse.getOutputStream().write(IOUtils.toByteArray(iBannerify.getBannerImage(request)));
	}
	
	/**
	 * @param request
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/fetchMemberPhoto", method = RequestMethod.GET)
	@ResponseBody
	public void fetchMemberPhoto(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		    httpServletResponse.setContentType("image/jpeg");
		    httpServletResponse.getOutputStream().write(iBannerify.fetchImage(request));
		
	}
	
	/**
	 * @param request
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/fetchBillingPdf", method = RequestMethod.GET)
	@ResponseBody
	public void fetchBillingPdf(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException{
		httpServletResponse.setContentType("application/pdf");
		httpServletResponse.getOutputStream().write(iBannerify.fetchPdf(request));
	}
}
