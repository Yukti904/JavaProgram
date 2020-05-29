package com.example.number;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NumberController {
	
	 static RestTemplate restTemp = new RestTemplate();
	 
	 @CrossOrigin(origins = "http://localhost:3000")
	 @RequestMapping("/getData")
	 private static String getNumberData(@RequestParam("number") Integer number,@RequestParam("type") String type)
	
	 {
		 final String uri = "https://numbersapi.p.rapidapi.com/6/21/date?fragment="+number+'&'+type+"&node=json&appid="+"655df09543msh51b0e04768091c9p15ff27jsn0212f61c3d98";
		 String result = restTemp.getForObject(uri,String.class);
		 
		 return result;
	 }	

}
