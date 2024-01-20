package design_pattern.chain_of_responsibility_pattern.filter;

import design_pattern.chain_of_responsibility_pattern.FilterChain;
import design_pattern.chain_of_responsibility_pattern.Request;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
