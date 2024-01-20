package design_pattern.chain_of_responsibility_pattern.response;

import design_pattern.chain_of_responsibility_pattern.Request;

public interface Response {
    void doResponse(Request request);
}
