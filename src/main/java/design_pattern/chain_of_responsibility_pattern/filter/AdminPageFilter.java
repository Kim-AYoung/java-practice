package design_pattern.chain_of_responsibility_pattern.filter;

import design_pattern.chain_of_responsibility_pattern.FilterChain;
import design_pattern.chain_of_responsibility_pattern.Member;
import design_pattern.chain_of_responsibility_pattern.Request;

public class AdminPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/admin")) {
            Member member = (Member) request.get("member");
            if (member.hasRole(Member.Role.ADMIN)) {
                System.out.printf("path : %s member role has ADMIN.%n", request.getPath());
                filterChain.doFilter(request);
            } else {
                System.out.printf("path : %s member role has not ADMIN.%n", request.getPath());
            }
        } else {
            System.out.println(this.getClass().getName() + " : 다음 필터로 넘김.");
            filterChain.doFilter(request);
        }
    }
}
