package gu.simplemq.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

class FastjsonEncoder2 extends FastjsonEncoder {
	private static final FastjsonEncoder2 INSTANCE = new FastjsonEncoder2();
	public static FastjsonEncoder2 getInstance(){
		return INSTANCE;		
	}
	private FastjsonEncoder2() {
	}

	@Override
	protected JSONObject doToJSONObject(Object bean) {
		// 直接解析成JSONObject 对象
		return  (JSONObject) JSON.toJSON(bean);
	}
}
