package com.alakey.serbiaguide.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guide_group")
    private String group;
    private String icon;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guide")
    private List<GuideItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<GuideItem> getItems() {
        return items;
    }

    public void setItems(List<GuideItem> items) {
        this.items = items;
    }
}