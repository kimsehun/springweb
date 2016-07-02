package kr.co.mysqljava.user;

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

}
