/**
 * 
 */
package com.rianta9.mona.security;

import java.util.ArrayList;
/**
 * @author rianta9
 * @datecreated 23 thg 4, 2021 00:00:24
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rianta9.mona.entity.Account;
import com.rianta9.mona.repository.AccountRepository;

/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserContext userContext;
	
	@Autowired(required = false)
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
    private AccountRepository accountRepository;

    @Override
	// Cần lấy :
	// + thông tin password để FW so sánh với password đang submit lên
	// + lấy các Quyền để FW check authorization
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		System.out.println("UserDetailsServiceImpl - loadUserByUsername - userName : " + userName);
		Account account = accountRepository.findByUsername(userName);
		if (account != null) {
			
			var selectedUserDetail = SelectedUserDetails.builder()
					.username(account.getUsername())
					.fullName(account.getFullName())
					.gender(account.getGender())
					.email(account.getEmail())
					.birthDay(account.getBirthDay())
					.roleId(account.getRole().getRoleCode())
					.build();
			userContext.update(selectedUserDetail);
			
			var grantList = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getRole().getRoleCode().toUpperCase());
			grantList.add(authority);

			String password = bCryptPasswordEncoder.encode(account.getPassword());
			UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(userName, password, grantList);
			return userDetails;
		} else
			throw new UsernameNotFoundException("User not found!");
	}

}
