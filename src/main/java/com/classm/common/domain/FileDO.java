package com.classm.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 *
 * @author
 * @email
 * @date 2017-09-19 16:02:20
 */
public class FileDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    // 文件类型
    private Integer type;
    // URLlink
    private String url;
    // 创建时间
    private Date createDate;


    public FileDO() {
        super();
    }


    public FileDO(Integer type, String url, Date createDate) {
        super();
        this.type = type;
        this.url = url;
        this.createDate = createDate;
    }


    /**
     *  Set:
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get: ：
     */
    public Long getId() {
        return id;
    }

    /**
     *  Set: 文件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Get: ：文件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     *  Set: URLlink
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get: ：URLlink
     */
    public String getUrl() {
        return url;
    }

    /**
     *  Set: 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get: ：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "FileDO{" +
                "id=" + id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
