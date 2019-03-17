package com.ccc.smse.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "web_menu_second")
public class WebMenuSecond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "href")
    private String href;

    @Column(name = "params")
    private String params;

    @ManyToOne
    @JoinColumn(name = "first_id",insertable = false,updatable = false)
    private WebMenu webMenu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public WebMenu getWebMenu() {
        return webMenu;
    }

    public void setWebMenu(WebMenu webMenu) {
        this.webMenu = webMenu;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder("<li><a href=\"")
                .append(this.getHref())
                .append("?")
                .append(this.getParams())
                .append("\"><span class=\"text\">")
                .append(this.getName())
                .append("</span></a></li>");
        return stringBuilder.toString();
    }
}