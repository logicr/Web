package club.logicr.springcore.entity;


import java.util.Date;

/**
 * 便签组
 * Author: secondriver
 * Created: 2018/6/18
 */
public class MemoGroup {
    
    /**
     * 便签组的编号-主键
     */
    private Integer id;
    
    /**
     * 便签组名称
     */
    private String name;
    
    /**
     * 便签组创建时间
     */
    private Date createdTime;
    
    /**
     * 便签组修改时间
     */
    private Date modifyTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public Date getModifyTime() {
        return modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    @Override
    public String toString() {
        return "MemoGroups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
