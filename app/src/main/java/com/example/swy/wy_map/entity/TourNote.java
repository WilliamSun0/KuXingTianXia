package com.example.swy.wy_map.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by swy on 2018/11/6.
 */
@Entity
public class TourNote {

    //主键
    @Id(autoincrement = true)
    private Long noteId;
    //旅行日记内容
    private String noteContext;
    @Generated(hash = 1827775499)
    public TourNote(Long noteId, String noteContext) {
        this.noteId = noteId;
        this.noteContext = noteContext;
    }
    @Generated(hash = 804519598)
    public TourNote() {
    }
    public Long getNoteId() {
        return this.noteId;
    }
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }
    public String getNoteContext() {
        return this.noteContext;
    }
    public void setNoteContext(String noteContext) {
        this.noteContext = noteContext;
    }
}
