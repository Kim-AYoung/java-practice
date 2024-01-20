package design_pattern.chain_of_responsibility_pattern;

import design_pattern.chain_of_responsibility_pattern.filter.Filter;
import design_pattern.chain_of_responsibility_pattern.response.AdminPageResponse;
import design_pattern.chain_of_responsibility_pattern.response.MyPageResponse;
import design_pattern.chain_of_responsibility_pattern.response.NotfoundPageResponse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new LinkedList<>();
    private Iterator iterator;

    public void addFilter(Filter filter) {
        this.filters.add(filter);
        iterator = filters.iterator();
    }

    public void doFilter(Request request) {

        if (iterator.hasNext()) {
            Filter nextFilter = (Filter) iterator.next();
            nextFilter.doFilter(request, this);
        } else {
            if (request.getPath().equals("/mypage")) {
                new MyPageResponse().doResponse(request);
            } else if (request.getPath().equals("/admin")) {
                new AdminPageResponse().doResponse(request);
            } else {
                new NotfoundPageResponse().doResponse(request);
            }
        }
    }
}
