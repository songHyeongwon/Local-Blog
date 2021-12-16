package com.marketboro.security.security;

import java.util.Collection;
import java.util.Collections;

import com.marketboro.security.been.Member;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class MyUserPrincipal implements UserDetails {

	private Member member;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
