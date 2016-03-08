package org.mvvm.dao;

import org.mvvm.Pojo.SidebarPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author amakarov
 */
public class SidebarPageConfig {
    HashMap<String,SidebarPage> pageMap = new LinkedHashMap<String,SidebarPage>();

    public SidebarPageConfig(){
        pageMap.put("books",new SidebarPage("books","Books","/content/books.zul"));
        pageMap.put("users",new SidebarPage("users","Users","/content/users.zul"));
    }

    public List<SidebarPage> getPages(){
        return new ArrayList<SidebarPage>(pageMap.values());
    }

    public SidebarPage getPage(String name){
        return pageMap.get(name);
    }
}
