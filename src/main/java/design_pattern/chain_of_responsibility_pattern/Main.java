package design_pattern.chain_of_responsibility_pattern;

public class Main {
    public static void main(String[] args) {
        Member user1 = Member.createUser("kima", "김아영", "1234");
        Member admin1 = Member.createAdmin("admin", "관리자", "1234");

        Request myPageRequest = new Request("/mypage");
        myPageRequest.put("member", user1);

        Request adminPageRequestByAdmin = new Request("/admin");
        adminPageRequestByAdmin.put("member", admin1);

        Request adminPageRequestByUser = new Request("/admin");
        adminPageRequestByUser.put("member", user1);

        Request fooPageRequest = new Request("/foo");
        fooPageRequest.put("member", user1);

        System.out.println("############## /mypage 요청 ############## ");
        HttpRequest httpRequest1 = new HttpRequest();
        httpRequest1.doRequest(myPageRequest);
        System.out.println();

        System.out.println("############## admin이 /admin 요청 ############## ");
        HttpRequest httpRequest2 = new HttpRequest();
        httpRequest2.doRequest(adminPageRequestByAdmin);
        System.out.println("############## user가 /admin 요청 ############## ");
        HttpRequest httpRequest3 = new HttpRequest();
        httpRequest3.doRequest(adminPageRequestByUser);
        System.out.println();

        System.out.println("############## /foo 요청 ############## ");
        HttpRequest httpRequest4 = new HttpRequest();
        httpRequest4.doRequest(fooPageRequest);
    }
}
