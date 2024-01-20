package design_pattern.chain_of_responsibility_pattern.filter;

import design_pattern.chain_of_responsibility_pattern.FilterChain;
import design_pattern.chain_of_responsibility_pattern.Member;
import design_pattern.chain_of_responsibility_pattern.Request;

public class MyPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/mypage")) {
            Member member = (Member) request.get("member");
            if (member.hasRole(Member.Role.USER)) {
                System.out.printf("path : %s member role has USER.%n", request.getPath());
                filterChain.doFilter(request);
            } else {
                System.out.printf("path : %s member role has not USER.%n", request.getPath());
            }
        } else {
            System.out.println(this.getClass().getName() + " : 다음 필터로 넘김.");
            filterChain.doFilter(request);
        }
    }
}
