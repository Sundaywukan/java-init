package cc.innosoft.thirdchat.controller;

import cc.innosoft.thirdchat.constant.Constant;
import cc.innosoft.thirdchat.constant.ResultMsg;
import cc.innosoft.thirdchat.domain.User;
import cc.innosoft.thirdchat.exception.BusinessException;
import cc.innosoft.thirdchat.exception.ParamException;

import javax.servlet.http.HttpSession;

public class BaseController {
	/**
	 * 获取用户
	 */
	public User getSessionUser(HttpSession session){
		Object obj = session.getAttribute(Constant.SESSION_USER);
		if (null == obj) {
			throw new BusinessException(ResultMsg.SESSION_USER_OVERDUE);
		}
		return (User) obj;
	}

	/**
	 * 校验验证码是否正确
	 * @param validCode
	 * @param session
	 * @return
	 * @throws ParamException
	 */
	public boolean checkValidCode(String validCode, HttpSession session) throws ParamException {
		Object sessionValidCode = session.getAttribute(Constant.VALID_CODE);
		Object count =  session.getAttribute(Constant.VALID_ERROR_COUNT);
		if(sessionValidCode == null || count == null){
			throw new ParamException(ResultMsg.VALIDCODE_NOT_EXIST);
		}
		
		Integer errorCount = Integer.parseInt(count+"");
		if(errorCount >Constant.VALID_ERROR_COUNT_MAX){
			//验证码错误5此需要重新获取，图形验证码
			session.removeAttribute(Constant.VALID_CODE);
			throw new BusinessException(ResultMsg.VALIDFAIL_COUNT_LG_FIVE);
		}
		
		if(validCode.equals(sessionValidCode+"")){
			session.removeAttribute(Constant.VALID_CODE);
			return true;
		}else{
			session.setAttribute(Constant.VALID_ERROR_COUNT, errorCount+1);
		}
		
		throw new ParamException(ResultMsg.VALIDCODE_ERROR);
	}
	
}
