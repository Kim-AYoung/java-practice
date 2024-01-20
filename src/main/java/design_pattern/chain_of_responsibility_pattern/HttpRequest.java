package design_pattern.chain_of_responsibility_pattern;

import design_pattern.chain_of_responsibility_pattern.filter.AdminPageFilter;
import design_pattern.chain_of_responsibility_pattern.filter.MyPageFilter;

public class HttpRequest {
    private final FilterChain filterChain = new FilterChain();

    public HttpRequest(){
        initFilter();
    }

    public void doRequest(Request request){
        filterChain.doFilter(request);
    }

    private void initFilter(){
        filterChain.addFilter(new MyPageFilter());
        filterChain.addFilter(new AdminPageFilter());
    }
}
