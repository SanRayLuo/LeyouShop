package com.leyou.search.pojo;

import java.util.Map;

/**
 * @author SanRay
 * @date 2019-07-16 15:02
 */
public class SearchRequest {

    private String key;// 搜索字段
    private Integer page;// 当前页
    private Map<String,String> filter;

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }

    private static final Integer DEFAULT_SIZE=20; //每页大小.从不同页面接收,而是固定大小
    private static final Integer DEFAULT_PAGE =1;// 默认页
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        if (page == null){
                return DEFAULT_PAGE;
        }
        // 获取页面时做一些检验,不能小于1
        return Math.max(DEFAULT_PAGE,page);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize(){
        return DEFAULT_SIZE;
    }
}