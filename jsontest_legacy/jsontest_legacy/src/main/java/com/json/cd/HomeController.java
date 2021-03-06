package com.json.cd;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.joy.cd.mb.vo.GetLstCardMapReqBVO;
import net.joy.cd.mb.vo.ListCardsResBVO;
import net.joy.cd.ut.GeneralAPIResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/getLstCardMap" , method = RequestMethod.GET, produces = "application/json")
	public GeneralAPIResponse getLstCardMap(GetLstCardMapReqBVO listCardsReqBVO, GeneralAPIResponse response,
				HttpServletRequest request, HttpSession session) throws Exception{ 

		logger.warn("strUid: " + listCardsReqBVO.getDstMemGuid());
		List<ListCardsResBVO> ListCardsResBVOLst = new ArrayList() ;
		
		ListCardsResBVO listCardsResBVO = new ListCardsResBVO() ;
		listCardsResBVO.setAlias("aa" );
		
		ListCardsResBVOLst.add(listCardsResBVO) ; 
		
 
		try {
			System.out.println("getLstCardMap : ");
			// ListCardsResBVOLst = cdmb_MngBIZ.getLstCardMap(listCardsReqBVO ) ; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		response.setResult(ListCardsResBVOLst) ; 
		
		return response;
		
	}	
	
	
}
