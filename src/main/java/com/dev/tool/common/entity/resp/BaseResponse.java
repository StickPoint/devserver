package com.dev.tool.common.entity.resp;
import com.dev.tool.common.entity.BaseEntity;
import com.dev.tool.common.enums.DevCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author fntp
 * @date 2022/1/22 23:24
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private int code;

    private T data;

    private String message;

    public BaseResponse(T res) {
        this.data = res;
    }

    public BaseResponse(String msg,int code,T data){
        this.data = data;
        this.code = code;
        this.message = msg;
    }

    /**
     * 成功通用
     * @param data 数据
     * @return 返回一个基础响应
     */
    public static BaseResponse<? extends BaseEntity> success(BaseEntity data){
        return new BaseResponse<>("success",20000,data);
    }

    /**
     * 失败通用
     * @param devCodeEnum 数据
     * @return 返回一个基础响应
     */
    public static BaseResponse<Object> failed(DevCodeEnum devCodeEnum){
        return new BaseResponse<>(devCodeEnum.getMessage(),devCodeEnum.getCode(),null);
    }

}
