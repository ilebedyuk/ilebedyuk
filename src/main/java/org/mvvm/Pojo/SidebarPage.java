package org.mvvm.Pojo;

/**
 * @author amakarov
 */
public class SidebarPage {
    private static final long serialVersionUID = 1L;
    String name;
    String label;
    String iconUri;
    String uri;

    public SidebarPage(String name, String label, String uri) {
        this.name = name;
        this.label = label;
        this.uri = uri;
    }

    public SidebarPage(String name, String label, String iconUri, String uri) {
        this.name = name;
        this.label = label;
        this.iconUri = iconUri;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getIconUri() {
        return iconUri;
    }

    public String getUri() {
        return uri;
    }
}
