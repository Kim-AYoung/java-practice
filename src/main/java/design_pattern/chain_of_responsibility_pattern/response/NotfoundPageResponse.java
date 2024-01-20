package design_pattern.chain_of_responsibility_pattern.response;

import design_pattern.chain_of_responsibility_pattern.Request;

public class NotfoundPageResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("###### response:NotfoundPageResponse #####");
        System.out.println("404 NotFound");
    }
}
