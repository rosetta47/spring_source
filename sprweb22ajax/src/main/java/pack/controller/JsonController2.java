package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	
	@GetMapping("list2")
	@ResponseBody
	// 복수일 때는 키 벨류로 넘겨야되
	public Map<String, Object> getJsons(){
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "공기밥");
		data.put("age", "23");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "북치기");
		data.put("age", "33");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "박치기");
		data.put("age", "25");
		dataList.add(data);
		//return data; 한명만 넘어가서 오류야
		System.out.println("data : " + data);
		//data : {name=박치기, age=25}
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList : " + dataList);
		//dataList : [{name=공기밥, age=23}, {name=북치기, age=33}, {name=박치기, age=25}]
		// @ResponseBody에 의해 {"datas":[{"name":"공기밥","age":"23"},{"name":"북치기","age":"33"},{"name":"박치기","age":"25"}]}
		return data2;
	}
}
