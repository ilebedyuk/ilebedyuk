package org.mvvm.viewModel;

import org.mvvm.Pojo.SidebarPage;
import org.mvvm.dao.SidebarPageConfig;

import java.util.List;

/**
 * @author amakarov
 */
public class SideBarAjaxViewModel {
    private SidebarPageConfig sidebarPageConfig = new SidebarPageConfig();

    public SideBarAjaxViewModel() {
    }

    public List<SidebarPage> getSidebarPages() {
        return sidebarPageConfig.getPages();
    }
}
