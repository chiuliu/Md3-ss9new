package com.ra.crud_demo.model;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@WebServlet("/user-servlet")

public class UserServlet extends HttpServlet {

    public static List<Users> usersList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        usersList.add(new Users("Lê Quang Tiệp",1, LocalDate.now(),"Bắc Ninh","0333125888"));
        usersList.add(new Users("Đàm Trọng Tấn",2, LocalDate.now(),"Bắc Ninh","0333125777"));
        usersList.add(new Users("Đàm Phương Anh",3, LocalDate.now(),"Bắc Ninh","0333125666"));
        usersList.add(new Users("Đào Hồng Ly",4, LocalDate.now(),"Hoà Bình","0333125555"));
        usersList.add(new Users("Đào Văn Hải",5, LocalDate.now(),"Hoà Bình","0333125444"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // phân biệt lúc hiển thị và lúc điều hướng sang trang add
        // parameter là tham số thì có cặp key-value

        String action = req.getParameter("action");
        action = action == null ? "" : action;
        System.out.println("action =" + action);
        switch (action){
            case "add": {
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
                break;
            }
            default:
                // lấy dữ liệu
                req.setAttribute("usersList", usersList);
                // điều hướng sang trang
                req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);

                super.doGet(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action){
            case "add": {
                String name = req.getParameter("name");
                String dob = req.getParameter("dob");
                LocalDate dateOfBirth = LocalDate.parse(dob);
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");

                Users users = new Users(name,getNewId(),dateOfBirth,address,phone);
                usersList.add(users);
                break;
            }
            default:
                // lấy dữ liệu
                req.setAttribute("usersList", usersList);
                // điều hướng sang trang
                req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
                super.doGet(req, resp);
        }
    }
    public int getNewId(){
        Optional<Users> users = usersList.stream().max(Comparator.comparingInt(Users::getId));
        return users.map(item -> item.getId()+1).orElse(1);
    }
}
