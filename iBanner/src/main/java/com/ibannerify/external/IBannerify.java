package com.ibannerify.external;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author shyam
 *
 */
public interface IBannerify {
	
	
	/**
	 * 
	 * @return
	 */
	InputStream getBannerImage(HttpServletRequest request);
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public byte[] fetchImage(HttpServletRequest request) throws IOException;
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public byte[] fetchPdf(HttpServletRequest request)throws IOException;

}
