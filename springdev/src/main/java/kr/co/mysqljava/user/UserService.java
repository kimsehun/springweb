package kr.co.mysqljava.user;

import java.util.List;


public interface UserService {

	void registUser(UserVO userVO) throws Exception;

	UserVO selectUser() throws Exception;

	List<UserVO> selectUserList() throws Exception;

	UserVO selectUser2(int uNumber) throws Exception;

	void updateAction(UserVO userVO) throws Exception;
	

}
