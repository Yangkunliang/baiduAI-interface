package com.ykl.demo.common;

/**  
 * 响应数据信息
 */
public class ResultData {
	private int code;
	private String message;
	private Object data;
	
	public ResultData() {
		
    }

    public ResultData(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
    
    public ResultData(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public static ResultData success(Object data) {
        return new ResultData(ResultCode.SUCCESS, data);
    }
	
	public static ResultData warn(ResultCode resultCode) {
		return new ResultData(resultCode);
    }
	
    public static ResultData warn(ResultCode resultCode, String message) {
    	ResultData result = new ResultData(resultCode);
        result.setMessage(message);
        return result;
    }

    public static ResultData error(ResultCode resultCode) {
        return new ResultData(resultCode);
    }
}
