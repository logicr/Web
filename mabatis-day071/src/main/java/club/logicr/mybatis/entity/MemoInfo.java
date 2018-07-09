package club.logicr.mybatis.entity;

import club.logicr.mybatis.common.BackGround;

import java.io.Serializable;
import java.util.Date;

public class MemoInfo implements Serializable {
    private Integer id;
    private Integer groupId;
    private String title;
    private String content;
    //0：公开 1：私密
    private Character privacy;
    private BackGround backGround;
    //0：不提醒 1：提醒
    private Character remind;
    private Date remindTime;
    private Date createdTime;
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Character getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Character privacy) {
        this.privacy = privacy;
    }

    public BackGround getBackGround() {
        return backGround;
    }

    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

    public Character getRemind() {
        return remind;
    }

    public void setRemind(Character remind) {
        this.remind = remind;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
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
        return "MemoInfo{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", privacy=" + privacy +
                ", backGround=" + backGround +
                ", remind=" + remind +
                ", remindTime=" + remindTime +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
