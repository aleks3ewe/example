package ru.rsreu.vkr.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionTimeoutFilter implements Filter
{
    private String timeoutPage = "index.jsp";
    private static int filterFlag;
 
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("Filtering started...");
    }
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("control transfer to doFilter block");
 
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse)
        {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 
            if (isSessionControlRequired(httpServletRequest))
            {
             
			if(filterFlag > 1)
                {
               if (isSessionInvalid(httpServletRequest))
                {
                    String timeoutUrl = httpServletRequest.getContextPath() + "/index.jsp";
                    System.out.println("Context path : " + httpServletRequest.getContextPath());
 
                    System.out.println("Session is invalid! Redirecting to timeoutpage : " + timeoutUrl);
 
                    httpServletResponse.sendRedirect(timeoutUrl);
 
                    return;
                }
                }
                filterFlag++;
            }
        }
        filterChain.doFilter(request, response);
    }
 
    private boolean isSessionControlRequired(HttpServletRequest httpServletRequest)
    {
        System.out.println("Control transfer to isSessionControlRequired");
        String requestPath = httpServletRequest.getRequestURI();
        System.out.println("Requested URI : "+requestPath);
 
        CharSequence timeOutPageinCharSequence  = getTimeoutPage().subSequence(0,getTimeoutPage().length());
        System.out.println("Context path : "+timeOutPageinCharSequence);
        boolean controlRequired =  !requestPath.contains(timeOutPageinCharSequence);
       
        System.out.println("control Required Status : "+controlRequired);
        return controlRequired;
    }
 
    private boolean isSessionInvalid(HttpServletRequest httpServletRequest)
    {
 
        System.out.println("Control transfer to isSessionValid");
        boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
                && !httpServletRequest.isRequestedSessionIdValid();
 
        return sessionInValid;
 
    }
 
    public void destroy()
    {
        System.out.println("Filter is destroyed..");
    }
 
    public String getTimeoutPage()
    {
 
        return timeoutPage;
 
    }
 
    public void setTimeoutPage(String timeoutPage)
    {
 
        this.timeoutPage = timeoutPage;
 
    }
}