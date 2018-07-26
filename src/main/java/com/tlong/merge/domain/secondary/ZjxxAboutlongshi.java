package com.tlong.merge.domain.secondary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_aboutlongshi")
public class ZjxxAboutlongshi {

    @Id
    private String id;

    //标题
    private String title;

    //内容
    private String content;

    //作者
    private String author;


}
