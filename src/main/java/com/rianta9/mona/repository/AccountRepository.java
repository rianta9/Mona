/**
 * 
 */
package com.rianta9.mona.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rianta9.mona.entity.Account;
import com.rianta9.mona.entity.common.EntityId;

/**
 * 
 * This interface is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, EntityId>{
	Optional<Account> findById(EntityId id);

	/**
	 * @param userName
	 * @return
	 */
	Account findByUsername(String username);

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@Query(value="select * from account as a where a.username=?1 and a.password=?2", nativeQuery=true)
	Account findByUsernameAndPassword(String username, String password);

	/**
	 * @param email
	 * @return
	 */
	Account findByEmail(String email);
	/**
	 * @param phone
	 * @return
	 */
	Account findByPhone(String phone);

	/**
	 * Dùng để kiểm tra email đã được sử dụng cho tài khoản khác hay chưa
	 * @param email
	 * @param accountId
	 * @return
	 */
	Account findByEmailAndIdNot(String email, Long accountId);

	/**
	 * Dùng để kiểm tra số điện thoại đã được sử dụng cho tài khoản khác hay chưa
	 * @param phone
	 * @param accountId
	 * @return
	 */
	Account findByPhoneAndIdNot(String phone, Long accountId);
}
