package com.Project.DealerService.config;

	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;

	import com.Project.DealerService.Entity.Dealers;

	import java.util.Arrays;
	import java.util.Collection;
	import java.util.List;
	import java.util.stream.Collectors;

	@SuppressWarnings("serial")
	public class UserInfoUserDetails implements UserDetails {

	    private String username;
	    private String password;
	    private List<GrantedAuthority> authorities;

	    public UserInfoUserDetails(Dealers dealerInfo) {
	        this.username = dealerInfo.getUsername();
	        this.password = dealerInfo.getPassword();
	        this.authorities = Arrays.stream(dealerInfo.getRole().split(","))
	                .map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return username;
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
  