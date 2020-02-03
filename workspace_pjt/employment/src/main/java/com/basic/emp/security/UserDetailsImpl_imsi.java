package com.basic.emp.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class UserDetailsImpl_imsi implements UserDetails {
	
	private String member_id;
    private String member_pw;
    private int lvl;
    private String authority;
    private boolean enabled;
    private String member_name;
    private String member_email;
    private Set<GrantedAuthority> sauthorities;  // 계정이 가지고 있는 권한 목록
    
    public UserDetailsImpl_imsi(String id, String password, String name, Collection<? extends GrantedAuthority> authorities){
        this.member_id = id;
        this.member_pw = password;
        this.member_name = name;
        this.sauthorities = Collections.unmodifiableSet(sortAuthorities(authorities));
      }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {// 유저의 계정이 갖고있는 권한 목록을 리턴
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		getMemberAuthority(); // 내가 정의한 메소드 호출 
		auth.add(new SimpleGrantedAuthority(authority));
        return auth;
	}

	@Override
	public String getPassword() {//유저의 계정 비밀번호
		return "{noop}"+member_pw;
	}

	@Override
	public String getUsername() {//유저의 계정 아이디
		return member_id;
	}

	@Override
	public boolean isAccountNonExpired() {//유저의 계정 만료여부 - true는 만료되지 않음
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {// 유저의 계정 잠김여부 - true는 잠기지 않음
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {// 유저의 계정 비밀번호 만료여부 - true는 만료되지 않음
		return true;
	}

	@Override
	public boolean isEnabled() {// 유저의 계정이 사용가능한지 여부 - true는 사용가능
		return enabled;
	}
	
	/**
	 * DB에서 lvl이 9이면 ADMIN 권한을 아니면 USER 권한을 지정해주는 메소드 
	 */
    public void getMemberAuthority() {
    	int lvl = getLvl();
    	String result = "ROLE_USER";
    	if(lvl==9) {
    		result = "ROLE_ADMIN";
    	}
    	this.authority = result;
    }
    
    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities =
            new TreeSet<GrantedAuthority>(new AuthorityComparator());
 
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
 
        return sortedAuthorities;
    }
    
    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
 
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }
 
            if (g1.getAuthority() == null) {
                return 1;
            }
 
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
