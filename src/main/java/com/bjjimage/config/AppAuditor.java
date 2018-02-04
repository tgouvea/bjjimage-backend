package com.bjjimage.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bjjimage.config.security.CustomUserDetail;

public class AppAuditor implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		
		return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
	} 
	

	}
