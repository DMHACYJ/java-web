package com.example.cs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (Invitation)实体类
 *
 * @author makejava
 * @since 2020-07-12 15:17:34
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name="invitation")
public class Invitation implements Serializable {
    private static final long serialVersionUID = -28378363222711212L;
    /**
    * 主键id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    * 标题
    */
    @Column(name = "title")
    private String title;
    /**
    * 内容
    */
    @Column(name = "content")
    private String content;
    /**
    * 类型
    */
    @Column(name = "type")
    private String type;

}