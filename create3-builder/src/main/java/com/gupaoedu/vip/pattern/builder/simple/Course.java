package com.gupaoedu.vip.pattern.builder.simple;

import lombok.Data;

/**
 * Created by Tom.
 */
@Data
public class Course {

    public void setName(String name) {
        this.name = name;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    private String name;
    private String ppt;
    private String video;
    private String note;

    private String homework;

    @Override
    public String toString() {
        return "CourseBuilder{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}
