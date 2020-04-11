package cn.caiqz.service.consumer.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author openshell
 * @since 2020-04-07
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 用户名
    private String username;

    // 密码
    private String password;

    private String phone;

    // 创建时间
    private Date created;

}
