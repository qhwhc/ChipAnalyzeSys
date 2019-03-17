package com.ccc.smse.pojo;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "web_menu")
public class WebMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "showName")
    private String showName;

    @Column(name = "href")
    private String href;

    @Column(name = "params")
    private String params;

    @Column(name = "iron")
    private String iron;

    @Column(name = "clazz")
    private String clazz;

    @OneToMany(mappedBy = "webMenu",fetch = FetchType.EAGER)
    private Set<WebMenuSecond> webMenuSeconds = new HashSet<WebMenuSecond>();

    public String getId() {
        return id;
    }

    public WebMenu setId(String id) {
        this.id = id;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
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

    public String getIron() {
        return iron == null ? "" : iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Set<WebMenuSecond> getWebMenuSeconds() {
        return webMenuSeconds;
    }

    public void setWebMenuSeconds(Set<WebMenuSecond> webMenuSeconds) {
        this.webMenuSeconds = webMenuSeconds;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = null;
        if(webMenuSeconds.size()>0){
            this.clazz = "nav-parent";
            stringBuilder =new StringBuilder("<li class=\"nav-parent\"><a>")
                    .append(this.getIron())
                    .append(this.getShowName())
                    .append("</a><ul class=\"nav nav-children\">");
            for(WebMenuSecond webMenuSecond : webMenuSeconds) {
                stringBuilder.append(webMenuSecond);
            };
                    stringBuilder.append("</ul></li>");

        }else{
            this.clazz = "active";
            stringBuilder =new StringBuilder("<li class=\"")
                    .append(this.getClazz())
                    .append("\"><a href=\"")
                    .append(this.getHref())
                    .append("?")
                    .append(this.getParams())
                    .append("\">")
                    .append(this.getIron())
                    .append(this.getShowName())
                    .append("</a>")
                    .append("</li>");
        }

        return stringBuilder.toString();
    }
}