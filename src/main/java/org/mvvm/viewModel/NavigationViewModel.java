package org.mvvm.viewModel;

import org.mvvm.Pojo.SidebarPage;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * @author amakarov
 */
public class NavigationViewModel {
    private String includeSrc = "/home.zul";

    @GlobalCommand("onNavigate")
    @NotifyChange("includeSrc")
    public void onNavigate(@BindingParam("page") SidebarPage page) {
        String locationUri = page.getUri();
        String name = page.getName();

        includeSrc = locationUri;

            //advance bookmark control,
            //bookmark with a prefix
//            if(name!=null){
//                Executions.getCurrent().getDesktop().setBookmark("p_"+name);
//            }
        }

    public String getIncludeSrc() {
        return includeSrc;
    }
}
