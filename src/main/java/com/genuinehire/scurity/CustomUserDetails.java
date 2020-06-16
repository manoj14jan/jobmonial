package com.genuinehire.scurity;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.genuinehire.domain.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;

	public CustomUserDetails(User user) {
		this.user= user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.print(user.getRole());
		return AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
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

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	public User getUser() { return user; }
}
