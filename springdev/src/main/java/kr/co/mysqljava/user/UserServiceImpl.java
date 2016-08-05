package kr.co.mysqljava.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void registUser(UserVO userVO) throws Exception {
		
		userMapper.registUser(userVO);
	}

	@Override
	public UserVO selectUser() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUser();
	}

	@Override
	public List<UserVO> selectUserList() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserList();
	}

	@Override
	public UserVO selectUser2(int uNumber) throws Exception{
		// TODO Auto-generated method stub
		return userMapper.selectUser2(uNumber);
	}

	@Override
	public void updateAction(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		
		int result = userMapper.updateAction(userVO);
	}
	

}
