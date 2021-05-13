package cybersoft.java11.crm.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import cybersoft.java11.crm.utils.UrlConstant;


@WebFilter(displayName = "siteMesh", urlPatterns = UrlConstant.ROOT)
public class SitemeshFilter extends SiteMeshFilter {

}
