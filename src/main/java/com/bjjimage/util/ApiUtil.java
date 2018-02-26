package com.bjjimage.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class ApiUtil {

	public static PageRequest pageRequestUtil(Integer page, Integer pageSize, String sort, String objOrd) {
		
		Sort sort2 = null;

		if ("asc".equalsIgnoreCase(sort)) {
			sort2 = new Sort(new Sort.Order(Sort.Direction.ASC, objOrd));
		} else {
			sort2 = new Sort(new Sort.Order(Sort.Direction.DESC, objOrd));
		}
		

		PageRequest pageRequest = new PageRequest(page, pageSize, sort2);
		return pageRequest;
	}
	
}
