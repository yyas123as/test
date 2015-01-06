import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * @ClassDescription: 判断类
 * @Author: Yang 
 * @CreateDate: 2014-5-16 下午10:19:25
 * @ModifyDescription: 
 */
public class YVerifier {
	
	/**
	 * @MethodDescription: 多个对象判空类
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:19:40
	 * @ModifyDescription: 
	 */
	public static boolean allEmpty(Object... obj){
		if(obj==null){
			return true;
		}else{
			for(Object o:obj){
				if(notEmpty(o)){
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * @MethodDescription: 判断非空
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:20:03
	 * @ModifyDescription: 
	 */
	public static boolean notEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	/**
	 * @MethodDescription: 判断空
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:20:23
	 * @ModifyDescription: 
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof String) {
			return "".equals((String) obj);
		}
		if (obj instanceof Object[]) {
			return ((Object[]) obj).length == 0;
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).size() == 0;
		}
		if (obj instanceof Map) {
			return ((Map<?,?>) obj).size() == 0;
		}
		return false;
	}
	
	/**
	 * @MethodDescription: 是否是数字
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:20:34
	 * @ModifyDescription: 
	 */
	public static boolean isNumber(char c) {
		return java.lang.Character.isDigit(c);
	}

	/**
	 * @MethodDescription: 判断字符串是否全部为数字
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:20:46
	 * @ModifyDescription: 
	 */
	public static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!isNumber(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @MethodDescription: 过滤数字类
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:21:04
	 * @ModifyDescription: 
	 */
	public static String filterNumber(String str){
		if(YVerifier.notEmpty(str)){
			String res = "";
			if (!isNumber(str.charAt(0))) {
				return str;
			}else{
				for (int i = 0; i < str.length(); i++) {
					if(isNumber(str.charAt(i))){
						res += str.charAt(i);
					}else{
						break;
					}
				}
				if(YVerifier.isEmpty(res)){
					return str;
				}else{
					return res.startsWith("0")?res:"0"+res;
				}
			}
		}else{
			return str;
		}
	}
	
	/**
	 * @MethodDescription: 创建嵌套文件夹
	 * @Author: Yang 
	 * @CreateDate: 2014-5-16 下午10:17:28
	 * @ModifyDescription: 
	 */
	public static boolean makeDirs(String file) {
		File f = new File(file);
		if (!f.getParentFile().isDirectory()) {
			return f.getParentFile().mkdirs();
		}
		return false;
	}
	
	public static void main(String args[]){
		String aa = "021u";
		System.out.println(filterNumber(aa));
	}
}
