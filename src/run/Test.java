package run;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        User admin = new User();
//        admin.setUserId(1);
//        admin.setUserEmail("admin@gmail.com");
//        admin.setUserPassword("123456");
//        admin.setUserName("");
//        admin.setUserPhone("");
//        admin.setUserRole(RoleName.ROLE_ADMIN);
//        admin.setUserStatus(true);
//        UserService.users.add(admin);
//        IOFile.writeObjectToFile(UserService.users,IOFile.USER_PATH);




        List<String> str=new ArrayList<String>();
        str.add("asd");
        str.add("abc");
        str.add("123");

        int a = (int) str.stream().filter(i->i.contains("a")).count();

        System.out.println(a);

    }
}
