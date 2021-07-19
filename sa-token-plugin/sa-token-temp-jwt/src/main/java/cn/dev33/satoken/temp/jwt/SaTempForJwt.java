package cn.dev33.satoken.temp.jwt;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.temp.SaTempInterface;
import cn.dev33.satoken.util.SaFoxUtil;

/**
 * Sa-Token 临时令牌验证模块接口 JWT实现类 
 * @author kong
 *
 */
public class SaTempForJwt implements SaTempInterface {
	
	/**
	 * 根据value创建一个token 
	 */
	@Override
	public String createToken(Object value, long timeout) {
		return SaJwtUtil.createToken(value, timeout, getJwtSecretKey());
	}
	
	/**
	 *  解析token获取value 
	 */
	@Override
	public Object parseToken(String token) {
		return SaJwtUtil.getValue(token, getJwtSecretKey());
	}
	
	/**
	 * 返回指定token的剩余有效期，单位：秒 
	 */
	@Override
	public long getTimeout(String token) {
		return SaJwtUtil.getTimeout(token, getJwtSecretKey());
	}
	
	/**
	 * 获取jwt秘钥 
	 * @return jwt秘钥 
	 */
	@Override
	public String getJwtSecretKey() {
		String jwtSecretKey = SaManager.getConfig().getJwtSecretKey();
		if(SaFoxUtil.isEmpty(jwtSecretKey)) {
			throw new SaTokenException("请配置：jwtSecretKey");
		}
		return jwtSecretKey;
	}
	
}
